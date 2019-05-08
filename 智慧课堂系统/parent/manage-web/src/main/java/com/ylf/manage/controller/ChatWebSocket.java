package com.ylf.manage.controller;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;

import javax.websocket.*;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

@ServerEndpoint("/chat")
public class ChatWebSocket {
    private CuratorFramework client=(CuratorFramework) ContextLoader.getCurrentWebApplicationContext().getBean("client");

    //记录当前在线人数
    private static int onlineCount=0;
    //用于保存客户端信息
    private static CopyOnWriteArraySet<ChatWebSocket> webSocketSet = new CopyOnWriteArraySet<ChatWebSocket>();
=======
=======
>>>>>>> by_19/5/8
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

@ServerEndpoint("/chat/{cId}")
public class ChatWebSocket {
    private CuratorFramework client=(CuratorFramework) ContextLoader.getCurrentWebApplicationContext().getBean("client");

    //班课标识符
    private String cId;
    //记录当前在线人数
    private static int onlineCount=0;
    //用于保存客户端信息
    private static ArrayList<ChatWebSocket> webSocketSet = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
    //客户端的session,需要通过它来给客户端发送消息
    private Session session;

    @OnOpen       //连接成功建立时触发
<<<<<<< HEAD
<<<<<<< HEAD
    public void OnOpen(Session session)throws Exception{
        this.session=session;
=======
    public void OnOpen(@PathParam("cId") String cId, Session session)throws Exception{
        this.session=session;
        this.cId=cId;
>>>>>>> zhkt-ok
=======
    public void OnOpen(@PathParam("cId") String cId, Session session)throws Exception{
        this.session=session;
        this.cId=cId;
>>>>>>> by_19/5/8
        webSocketSet.add(this);
        onlineCountAdd();
        System.out.println("有新用户加入，当前在线人数："+getOnlineCount());
    }

    @OnClose     //连接关闭时触发
    public void OnClose()throws Exception{
        webSocketSet.remove(this);
        onlineCountSub();
        System.out.println("有用用户退出，当前在线人数："+getOnlineCount());
    }

    @OnMessage  //当收到客户端消息时触发,向所有客户端发消息
    public void OnMessage(String message,Session session){
<<<<<<< HEAD
<<<<<<< HEAD
        for (ChatWebSocket chat:webSocketSet){
            try{
                Date date=new Date();
                String msg=message+" "+date.toLocaleString();
                chat.session.getAsyncRemote().sendText(msg);
=======
=======
>>>>>>> by_19/5/8
        String[] m=message.split("&");
        for (ChatWebSocket chat:webSocketSet){
            try{
                if(chat.getcId().equals(m[1])){
                    Date date=new Date();
                    String msg=m[0]+" "+date.toLocaleString();
                    chat.session.getAsyncRemote().sendText(msg);
                }
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

        }
    }

    @OnError  //发生错误时触发
    public void OnError(Session session,Throwable e){
         e.printStackTrace();
    }

    public  int getOnlineCount() {   //返回当前在线人数
        try {
            InterProcessMutex mutex = new InterProcessMutex(client, "/count");
            try{
                if (mutex.acquire(1, TimeUnit.HOURS)) {
                     return onlineCount;
                }
                return onlineCount;
            }finally {
                mutex.release();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return onlineCount;
        }
    }

    public  void onlineCountAdd() {        //在线人数加一
        try {
            InterProcessMutex mutex = new InterProcessMutex(client, "/add");
            try{
                if (mutex.acquire(1, TimeUnit.HOURS)) {
                    ChatWebSocket.onlineCount++;
                }
            }finally {
                mutex.release();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void onlineCountSub(){        //在线人数加一
        try {
            InterProcessMutex mutex = new InterProcessMutex(client, "/sub");
            try{
                if (mutex.acquire(1, TimeUnit.HOURS)) {
                    ChatWebSocket.onlineCount--;
                }
            }finally {
                mutex.release();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> by_19/5/8

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
}
