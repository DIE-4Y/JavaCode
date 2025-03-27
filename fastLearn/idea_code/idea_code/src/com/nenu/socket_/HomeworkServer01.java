package com.nenu.socket_;

import com.nenu.file_.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class HomeworkServer01 {
    public static void main(String[] args) throws IOException {
        String ip = "10.90.175.227";
        //监听9999窗口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待建立连接");
        //建立连接
        Socket socket = serverSocket.accept();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        byte[] data = StringUtils.streamToByteArray(bis);
        String s = new String(data);
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        if("name".equals(s)){
            bw.write("张三");
        } else if ("hobby".equals(s)) {
            bw.write("开挖掘机");
        }else {
            bw.write("你说啥呢");
        }
        bw.flush();
        socket.shutdownOutput();

        //关闭资源
        bw.close();
        bis.close();
        serverSocket.close();
        System.out.println("server01关闭");
    }
}
