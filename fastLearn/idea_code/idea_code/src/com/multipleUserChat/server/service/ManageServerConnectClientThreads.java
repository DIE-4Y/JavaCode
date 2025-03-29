package com.multipleUserChat.server.service;

import java.util.HashMap;

/**
 * 管理通信线程
 */
public class ManageServerConnectClientThreads {
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    public static void add(String userId, ServerConnectClientThread serverConnectClientThread) {
        hashMap.put(userId, serverConnectClientThread);
    }

    public static ServerConnectClientThread getThread(String userId) {
        return hashMap.get(userId);
    }
}
