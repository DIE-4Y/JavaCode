package com.multipleUserChat.server.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;
import com.multipleUserChat.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private ServerSocket serverSocket;
    private static HashMap<String, User> validUsers = new HashMap<>();
    //可使用ConcurrentHashMap--线程安全
    //private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

    //静态代码块，只初始化一次
    static {
        validUsers.put("100", new User("100", "1111"));
        validUsers.put("200", new User("200", "1111"));
        validUsers.put("300", new User("300", "1111"));
        validUsers.put("400", new User("400", "1111"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "1111"));
        validUsers.put("至尊宝", new User("至尊宝", "1111"));
        validUsers.put("许褚", new User("许褚", "1111"));

    }

    public ChatServer() {
        new Thread(new SendNewsToAllService()).start();
        while (true) {
            try {
                System.out.println("正在监听9999端口");
                serverSocket = new ServerSocket(9999);
                Socket socket = serverSocket.accept();
                //判断用户登录是否合法
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) ois.readObject();
                Message message = new Message();
                if (checkUser(user.getUsrId(), user.getPassword())) {
                    //如果合法就登录成功返回数据
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    oos.flush();
                    System.out.println(user.getUsrId() + "登录成功");
                    //socket加入线程
                    ServerConnectClientThread thread = new ServerConnectClientThread(user.getUsrId(), socket);
                    thread.start();
                    //线程加入管理
                    ManageServerConnectClientThreads.add(user.getUsrId(), thread);

                } else {
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    oos.flush();
                    socket.shutdownOutput();
                    //关闭资源
                    oos.close();
                    socket.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public boolean checkUser(String userId, String password) {
        User user = validUsers.get(userId);
        if (user == null) {
            return false;
        }
        if (!user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

}
