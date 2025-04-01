package com.multipleUserChat.client.chat;

import com.multipleUserChat.client.service.ClientService;
import com.multipleUserChat.client.utils.Util;

/**
 * 客户端主界面
 */
public class ChatView {

    private boolean loop = true;
    private char key;
    private ClientService clientService = new ClientService();

    public static void main(String[] args) {
        new ChatView().mainMenu();
    }

    public void mainMenu() {
        do {
            System.out.println("==============欢迎登录网络通信系统=============");
            System.out.println("\t\t\t\t1 登录");
            System.out.println("\t\t\t\t9 退出");
            System.out.print("==============请输入>>:");
            key = Util.getChar();
            switch (key) {
                case '1':
                    System.out.print("请输入用户名>>:");
                    String userId = Util.getString(20);
                    System.out.print("请输入密  码>>:");
                    String password = Util.getString(20);
                    //登录判断发送数据，进行连接
                    if (clientService.checkUser(userId, password)) {
                        System.out.println("==============欢迎 " + userId + "登录=============");
                        do {
                            System.out.println("==============欢迎登录网络通信二级菜单（" + userId + "）=============");
                            System.out.println("\t\t\t\t1 显示在线用户信息");
                            System.out.println("\t\t\t\t2 群发消息");
                            System.out.println("\t\t\t\t3 私聊消息");
                            System.out.println("\t\t\t\t4 发送文件");
                            System.out.println("\t\t\t\t9 退出系统");
                            System.out.print("请输入您的操作>>:");
                            key = Util.getChar();
                            switch (key) {
                                case '1':
                                    System.out.println("在线用户");
                                    break;
                                case '2':
                                    System.out.println("群发消息");
                                    break;
                                case '3':
                                    System.out.println("私聊消息");
                                    break;
                                case '4':
                                    System.out.println("发送文件");
                                    break;
                                case '9':
                                    System.out.println("========正在退出=======");
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入错误，正在返回一级页面");
                                    break;
                            }
                        } while (loop);
                    } else {
                        System.out.println("登录验证不通过，正在返回一级页面");
                    }
                    break;
                case '9':
                    System.out.println("========正在退出=======");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，正在返回一级页面");
            }
        } while (loop);
    }
}
