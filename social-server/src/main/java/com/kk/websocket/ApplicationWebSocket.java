package com.kk.websocket;

import com.mysql.cj.protocol.Message;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author KK
 * @create 12/20/2020
 */
@ServerEndpoint(value = "/websocket")
@Component
public class ApplicationWebSocket {
    private static final CopyOnWriteArraySet<ApplicationWebSocket> webSocket = new CopyOnWriteArraySet<>();
    private static final HashMap<Integer,Message> messageHashMap = new HashMap<>();
    private Session session;
    @OnOpen
    public void onOpen(Session session) {
        webSocket.add(this);
    }
    @OnMessage
    public void onMessage(String text) {

    }
    @OnClose
    public void onClose() {

    }
}
