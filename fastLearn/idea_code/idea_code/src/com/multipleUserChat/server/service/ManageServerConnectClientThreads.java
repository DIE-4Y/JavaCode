package com.multipleUserChat.server.service;

import java.util.HashMap;

/**
 * 管理通信线程
 */
public class ManageServerConnectClientThreads {
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    public static void add(String userId, ServerConnectClientThread serverConnectClientThread) {
        System.out.println("已将该线程纳入管理~~");
        hashMap.put(userId, serverConnectClientThread);
    }

    public static ServerConnectClientThread getThread(String userId) {
        return hashMap.get(userId);
    }

    public static String getOnlineUser() {
        String userList = "";
        for (String key : hashMap.keySet()) {
            userList += key + " ";
        }
        return userList;
    }

    public static void removeThread(String userId){
        hashMap.remove(userId);
    }
}
