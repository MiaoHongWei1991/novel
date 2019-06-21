package com.novel.cn.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 开启WebSocket支持
 * 李川东  2018/7/916:54
 */
@Configuration
public class WebSocketConfig {


    @Value("${socketio.port}")
    private int port;
    @Value("${socketio.host}")
    private String hostName;
    @Value("${socketio.heartbeatTimeout}")
    private int heartBeatTimeOut;

    @Bean
    public SocketIOServer opSocket(){

        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();

        configuration.setPort(port);
        configuration.setTransports(Transport.POLLING,Transport.WEBSOCKET);
//        configuration.setHeartbeatTimeout(heartBeatTimeOut);
//        configuration.setAllowCustomRequests(true);
//        configuration.setOrigin("*");
//        configuration.setOrigin(null);
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        socketConfig.setTcpNoDelay(true);
        socketConfig.setSoLinger(0);
        configuration.setSocketConfig(socketConfig);
        configuration.setHostname(hostName);
        SocketIOServer socketIOServer = new SocketIOServer(configuration);
        socketIOServer.start();
        return socketIOServer;
    }
}
