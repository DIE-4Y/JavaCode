package com.nenu.socket_;

import com.nenu.file_.StringUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpFileCopyClient {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //读入文件
        String filePath = "C:\\Users\\faker\\Pictures\\Saved Pictures\\头像\\face.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] data = StringUtils.streamToByteArray(bis);
        //发送文件
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(data);
        bos.close();
        socket.shutdownOutput();//结束标志

        //接收消息
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        System.out.println(isr.read());

        //关闭流
        bis.close();
        socket.close();
    }
}
