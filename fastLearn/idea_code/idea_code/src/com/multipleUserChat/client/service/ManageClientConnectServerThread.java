package com.multipleUserChat.client.service;

import java.util.HashMap;

/**
 * 用于管理ClientConnectServerThread线程的类
 */
public class ManageClientConnectServerThread {
    //用户的所有线程都在这里边被管理
    private static HashMap<String, ClientConnectServerThread> hashMap = new HashMap<>();

    //添加线程进行管理
    public static void add(String userId, ClientConnectServerThread thread) {
        hashMap.put(userId, thread);
    }

    //获得一个线程
    public static ClientConnectServerThread get(String userId){
        return hashMap.get(userId);
    }
}
