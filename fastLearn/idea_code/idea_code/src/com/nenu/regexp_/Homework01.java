package com.nenu.regexp_;

/**
 * 检验电子邮件格式是否合法
 * 1.只能有1个@
 * 2.前面是用户名 可包含a-z，A-Z _ - 等字符
 * 3.后边域名只能是英文字母
 */
public class Homework01 {
    public static void main(String[] args) {
        String content = "src10086@.qq.com";
        System.out.println("该内容是邮件地址为=" + content.matches("[\\w-]+@([a-zA-Z]+\\.)+[a-zA-z]+"));
    }

}
