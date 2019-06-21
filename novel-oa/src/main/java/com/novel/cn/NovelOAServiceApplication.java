package com.novel.cn;/**
 * Created by danny on 2018-04-09.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import javax.servlet.MultipartConfigElement;

/**
 * @author danny
 * @create 2018-04-09 17:09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
@EnableWebSocket
@EnableScheduling //启用定时任务
@MapperScan(basePackages = "com.novel.cn.dao.mapper")
@EnableTransactionManagement
@ServletComponentScan  //开启servlet注解
@EnableAsync    //开启异步任务
@PropertySource(value = {"file:${novelpath}/novel-service.properties",
                            "file:${novelpath}/redis.properties",
                            "file:${novelpath}/mysql.properties",
                            "file:${novelpath}/application.properties",
                            "file:${novelpath}/socketio.properties"})
public class NovelOAServiceApplication {

    @Value("${spring.http.multipart.max-file-size}")
    private String maxFileSize;
    @Value("${spring.http.multipart.max-request-size}")
    private String maxRequestSize;

    public static void main(String[] args) {

        SpringApplication.run(NovelOAServiceApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //允许上传的文件最大值
        factory.setMaxFileSize(maxFileSize); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(maxRequestSize);
        return factory.createMultipartConfig();
    }
}
