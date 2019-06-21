package com.novel.cn.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by le on 2018/3/27.
 */
@Configuration
public class MongodbConfig {

    //    @Value("${mongodb.host}")
    private String mongoHost;

    /*mongo集群地址*/
    @Value("${mongodb.cluster.hosts}")
    private String mongoClusterHost;
    @Value("${mongodb.cluster.userName}")
    private String userName;
    @Value("${mongodb.cluster.database}")
    private String mgDatabase;
    @Value("${mongodb.cluster.password}")
    private String password;
    //    @Value("${mongodb.port}")
    private int mongoPort;

    //    @Value("${mongodb.database}")
    private String database;

    /*构建mongo单机版客户端*/
//    @Bean(name = "mongodbClient")
    public MongoClient buildClient() {
        MongoClientOptions myOptions = createBuildOptions().build();
        MongoClient mongoClient = new MongoClient(mongoHost, myOptions);
        return mongoClient;
    }

    /*构建mongo集群客户端*/
    @Bean(name = "mongoClusterClient")
    public MongoClient buildMongoClusterClient() {
        MongoCredential credential = MongoCredential.createCredential(userName, mgDatabase, password.toCharArray());
        String[] hosts = mongoClusterHost.split(",");
        List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        for (String host : hosts) {
            String[] info = host.split(":");
            ServerAddress address = new ServerAddress(info[0], Integer.valueOf(info[1]));
            addresses.add(address);
        }
        MongoClientOptions.Builder build = createBuildOptions();
        //在复制集中优先读secondary，如果secondary访问不了的时候就从master中读
        build.readPreference(ReadPreference.secondaryPreferred());
        MongoClientOptions myOptions = build.build();
        MongoClient mongoClient = new MongoClient(addresses, Arrays.asList(credential), myOptions);
        return mongoClient;
    }

    private MongoClientOptions.Builder createBuildOptions() {
        MongoClientOptions.Builder build = new MongoClientOptions.Builder();
        build.connectionsPerHost(100);   //与目标数据库能够建立的最大connection数量为50
        build.threadsAllowedToBlockForConnectionMultiplier(50); //如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
        /*
         * 一个线程访问数据库的时候，在成功获取到一个可用数据库连接之前的最长等待时间为2分钟
         * 这里比较危险，如果超过maxWaitTime都没有获取到这个连接的话，该线程就会抛出Exception
         * 故这里设置的maxWaitTime应该足够大，以免由于排队线程过多造成的数据库访问失败
         */
        build.maxWaitTime(1000 * 60 * 2);
        build.connectTimeout(1000 * 60 * 1);    //与数据库建立连接的timeout设置为1分钟
        return build;
    }

}
