package com.nenu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析url
 * 获取 协议 (http/https) 域名 (www.baidu.com) 端口 (3306) 文件名 (index.html)
 */
public class Homework03 {
    public static void main(String[] args) {
        String content = "http://www.baidu.com:5583/?key=10/index.html";
        String reg = "([a-zA-z]+)://([a-zA-Z.]+):(\\d+)[\\w/?=\\d]*/([\\w.]+)";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(content);
        if(matcher.matches()){
            System.out.println("协议="+matcher.group(1));
            System.out.println("域名="+matcher.group(2));
            System.out.println("端口="+matcher.group(3));
            System.out.println("文件名="+matcher.group(4));
        }else {
            System.out.println("未匹配到");
        }
    }
}
