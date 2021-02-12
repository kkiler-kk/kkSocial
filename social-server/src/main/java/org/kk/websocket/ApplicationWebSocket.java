package org.kk.websocket;

import com.mysql.cj.protocol.Message;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author KK
 * @create 12/20/2020
 */
@ServerEndpoint(value = "/websocket")
@Component
public class ApplicationWebSocket {
    private static final CopyOnWriteArraySet<ApplicationWebSocket> webSocket = new CopyOnWriteArraySet<>();
    private static final List<Message> messageList = new ArrayList<>();
    private Session session;
    @OnOpen
    public void onOpen(Session session) {
    }
    @OnMessage
    public void onMessage(String text) {

    }
    @OnClose
    public void onClose() {

    }
}
