package com.multipleUserChat.server.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;
import com.multipleUserChat.utils.Util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

public class SendNewsToAllService implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.print("请输入需要广播的通知,(输入exit退出线程)>>:");
            String news = Util.getString(50);
            if ("exit".equalsIgnoreCase(news)) {
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setMsgType(MessageType.MESSAGE_COMMON_MESSAGE_TO_ALL);
            HashMap<String, ServerConnectClientThread> hashMap = ManageServerConnectClientThreads.getHashMap();
            Iterator<String> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                String onlineUserId = iterator.next().toString();
                //获取每个socket并发送数据
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(hashMap.get(onlineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("服务器向全体在线用户推送:" + news);
        }
    }
}
