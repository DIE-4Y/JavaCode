package com.multipleUserChat.common;

public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED="1";//登录成功返回1
    String MESSAGE_LOGIN_FAIL="2";//登录失败返回2
    String MESSAGE_COMMON_MESSAGE="3";//发送普通消息
    String MESSAGE_GET_ONLINE_FRIEND="4";//获取在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND="5";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT="6";//客户端退出
}
