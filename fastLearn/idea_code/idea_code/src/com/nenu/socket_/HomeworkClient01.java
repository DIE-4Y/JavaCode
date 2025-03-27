package com.nenu.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class HomeworkClient01 {
    public static void main(String[] args) throws IOException {
        String ip = "10.90.175.227";
        //建立连接
        Socket socket = new Socket(InetAddress.getByName(ip), 9999);
        //发送数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("gender");
        bw.flush();
        socket.shutdownOutput();
        System.out.println("发送数据完成");
        //获取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] data= new char[1024];
        br.read(data);
        System.out.println(data);

        //关闭资源
        bw.close();
        socket.close();
        System.out.println("client01关闭");
    }
}
