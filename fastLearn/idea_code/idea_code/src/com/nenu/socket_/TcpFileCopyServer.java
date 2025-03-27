package com.nenu.socket_;

import com.nenu.file_.StringUtils;
import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileCopyServer {
    public static void main(String[] args) throws IOException {
        String storePath="d:\\桌面\\dog.png";
        //监听窗口
        ServerSocket serverSocket = new ServerSocket(8888);
        //建立连接
        Socket socket = serverSocket.accept();
        //获取数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] data = StringUtils.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(storePath));
        bos.write(data);
        bos.flush();

        //返回消息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("文件复制成功~~");
        bw.flush();
        socket.shutdownOutput();

        //关闭流和其他内容
        bw.close();
        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();

    }
}
