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
        bos.close();

        //返回消息
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        osw.write("文件复制成功~~");
        osw.flush();
        osw.close();
        socket.shutdownOutput();

        //关闭流
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
