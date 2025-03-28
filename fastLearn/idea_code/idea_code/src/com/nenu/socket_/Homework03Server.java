package com.nenu.socket_;

import com.nenu.file_.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\桌面\\";
        String ip = "10.90.175.227";
        //等待建立连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待建立连接");
        //连接建立获取文件名
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        String fileName = "";
        while ((len = inputStream.read(bytes)) != -1) {
            fileName += new String(bytes, 0, len);
        }
        File file = new File(filePath + fileName);
        //寻找文件并发送
        if (file.exists()) {
            System.out.println("文件存在，正在发送");
        } else {
            System.out.println("没找到对应文件，发送默认文件：a.txt");
            file = new File(filePath+"a.txt");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] data = StringUtils.streamToByteArray(bis);
        bis.close();
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(data);
        bos.flush();
        socket.shutdownOutput();
        //关闭资源
        bos.close();
        socket.close();
    }
}

//public class Homework03Server {
//        public static void main(String[] args) throws IOException {
//        String filePath = "d:\\桌面\\";
//        String ip = "10.90.175.227";
//        //等待建立连接
//        ServerSocket serverSocket = new ServerSocket(9999);
//        System.out.println("等待建立连接");
//        //连接建立获取文件名
//        Socket socket = serverSocket.accept();
//        InputStream inputStream = socket.getInputStream();
//
//        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//        String s = StringUtils.steamToString(bis);
//        File file = new File(filePath + s);
//        byte[] buf = new byte[1024 * 64];
//        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
//        //寻找文件并发送
//        if ("a.txt".equals(s)) {
//            System.out.println("文件存在，正在发送");
//            bis = new BufferedInputStream(new FileInputStream(file));
//            bis.read(buf);
//            bis.close();
//            bos.write(buf);
//            bos.flush();
//            socket.shutdownOutput();
//        } else {
//            System.out.println("未找到文件路径：" + filePath + s);
//            System.out.println("文件不存在，正在发送默认文件");
//            bis = new BufferedInputStream(new FileInputStream(filePath+"a.txt"));
//            bis.read(buf);
//            bis.close();
//            bos.write(buf);
//            bos.flush();
//            socket.shutdownOutput();
//        }
//
//        //关闭资源
//        bos.close();
//        socket.close();
//    }
//}