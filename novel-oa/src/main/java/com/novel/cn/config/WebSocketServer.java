package com.novel.cn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket实现
 * zhaolei  2018/7/916:58
 */
@ServerEndpoint(value = "/websocket/{novelId}/{userSessionId}")
@Component
@Slf4j
public class WebSocketServer {
    private static int onlineCount=0;
    private static ConcurrentHashMap<String,ConcurrentHashMap<String,WebSocketServer>> webSocketMap=new ConcurrentHashMap<String,ConcurrentHashMap<String, WebSocketServer>>();
    private Session session;
    private String novelId="";
    private String userSessionId="";
    @OnOpen
    public void onOpen(Session session, @PathParam("novelId") String novelId ,@PathParam("userSessionId") String userSessionId,EndpointConfig config){
        this.session=session;
        this.novelId=novelId;
        this.userSessionId=userSessionId;
        ConcurrentHashMap<String, WebSocketServer> novelMap = webSocketMap.get(novelId);
        if (novelMap ==null){
            ConcurrentHashMap<String, WebSocketServer>  noticeMap= new ConcurrentHashMap<>();
            noticeMap.put(userSessionId,this);
            webSocketMap.put(novelId,noticeMap);
        }else{
            WebSocketServer webSocketServer = novelMap.get(userSessionId);
            if (webSocketServer==null){
                novelMap.put(userSessionId,this);
                webSocketMap.put(novelId,novelMap);
            }
        }
        addOnlineCount();
        log.info("webSocket连接成功------》当前在线人数："+getOnlineCount());
    }
    public static void sendInfo(String message,@PathParam("novelId") String novelId,@PathParam("userSessionId") String userSessionId) {
        Iterator<Map.Entry<String, ConcurrentHashMap<String, WebSocketServer>>> iterator = webSocketMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, ConcurrentHashMap<String, WebSocketServer>> next = iterator.next();
            if (next.getKey().equals(novelId)){
                ConcurrentHashMap<String, WebSocketServer> value = next.getValue();
                Enumeration<String> keys = value.keys();
                while (keys.hasMoreElements()){
                    String s = keys.nextElement();
                    value.get(s).sendMessage(message);
                }
            }
        }
    }

    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("WebSocket推送消息异常：{}",e);
        }
    }

    @OnClose
    public void onClose() {
        ConcurrentHashMap<String, WebSocketServer> novelMap = webSocketMap.get(novelId);
        if (novelMap ==null){
            webSocketMap.remove(novelId);
        }else{
            novelMap.remove(userSessionId);
            webSocketMap.put(novelId,novelMap);
        }
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
