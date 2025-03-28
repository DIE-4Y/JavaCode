package com.nenu.socket_;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws IOException {
        String ip = "10.90.175.227";
        String storePath="D:\\桌面\\temp\\";
        //建立连接
        Socket socket = new Socket(ip, 9999);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你需要的文件（有a.txt）>>:");
        byte[] fileName = scanner.next().getBytes();
        //传输文件名
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(fileName);
        bos.flush();
        socket.shutdownOutput();
        //获取文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] data =new byte[1024*64];
        int len = bis.read(data);
        bos = new BufferedOutputStream(new FileOutputStream(storePath+new String(fileName)));
        bos.write(data, 0, len);
        bos.flush();

        //关闭资源
        bis.close();
        bos.close();
        socket.close();
    }
}
