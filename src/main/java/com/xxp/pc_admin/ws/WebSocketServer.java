package com.xxp.pc_admin.ws;

import com.xxp.pc_admin.domain.AdminUser;
import com.xxp.pc_admin.security.WebSecurity;
import com.xxp.pc_admin.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/webSocket/{token}")
@Component
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();

    private static JwtTokenUtil jwtTokenUtil;

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        WebSocketServer.jwtTokenUtil = jwtTokenUtil;
    }

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    public static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

    //发送消息
    public void sendMessage(Session session, String message) throws IOException {
        if (session != null) {
            synchronized (session) {
//                System.out.println("发送数据：" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }

    //给指定用户发送信息
    public static void sendInfo(String userName, String message) {
        Session session = sessionPools.get(userName);
        if (session != null) {
            synchronized (session) {
//                System.out.println("发送数据：" + message);
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //建立连接成功调用
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "token") String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        sessionPools.put(username, session);
        addOnlineCount();
        sendAll("flash");
        System.out.println(username + "加入webSocket！当前人数为" + onlineNum);
    }

    //关闭连接时调用
    @OnClose
    public void onClose(@PathParam(value = "token") String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        sessionPools.remove(username);
        subOnlineCount();
        System.out.println(username + "断开webSocket连接！当前人数为" + onlineNum);
    }

    //收到客户端信息
    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println(message);
        String[] split = message.split("##");
        String username = jwtTokenUtil.getUsernameFromToken(split[2]);
        String msg = username + ":" + split[0];
        if ("所有人".equals(split[1])) {
            for (Session session : sessionPools.values()) {

                try {
                    sendMessage(session, msg);

                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            sendMessage(sessionPools.get(username), "发送成功!");
        } else {
            String to = split[1];
            if (sessionPools.containsKey(to)) {
                Session session = sessionPools.get(to);
                sendMessage(session, msg);
                sendMessage(sessionPools.get(username), "发送成功!");
            } else {
                Session session = sessionPools.get(username);
                sendMessage(session, "该用户已离线");
            }
        }
    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount() {
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }

    public void sendAll(String message) {
        for (Session session : sessionPools.values()) {

            try {
                sendMessage(session, message);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

}
