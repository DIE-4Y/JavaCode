package com.multipleUserChat.common;

public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED="1";//登录成功返回1
    String MESSAGE_LOGIN_FAIL="2";//登录失败返回2
    String MESSAGE_COMMON_MESSAGE="3";//发送普通消息
    String MESSAGE_GET_ONLINE_FRIEND="4";//获取在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND="5";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT="6";//客户端退出
    String MESSAGE_COMMON_MESSAGE_TO_ALL="7";//群发消息
    String MESSAGE_FILE_MESSAGE="8";//发送文件
    String MESSAGE_LEFT_MESSAGE="9";//留言文件
}
