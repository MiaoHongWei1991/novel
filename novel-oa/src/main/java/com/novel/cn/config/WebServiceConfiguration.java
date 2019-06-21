package com.novel.cn.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by le on 2018/3/22.
 */

@Configuration
public class WebServiceConfiguration {

    @Value("${zuul.service.port}")
    private String port;

    @Value("${zuul.server.address}")
    private String address;

    private static final Integer MAX_CONNECTIONS=2000;

    private static final Integer MAX_Threads=2000;

    private static final Integer Connection_Timeout=30000;

    @Autowired
    private Environment environment;

    @Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory()
    {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        InetAddress inetAddress= null;
        try {
            inetAddress = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        tomcatFactory.setPort(Integer.valueOf(port));
        tomcatFactory.setAddress(inetAddress);
        tomcatFactory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
        return tomcatFactory;
    }

    class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer
    {
        public void customize(Connector connector)
        {
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            //设置最大连接数
            protocol.setMaxConnections(MAX_CONNECTIONS);
            //设置最大线程数
            protocol.setMaxThreads(MAX_Threads);
            //设置连接超时
            protocol.setConnectionTimeout(Connection_Timeout);
        }
    }
}
