package com.nenu.regexp_;

/**
 * 验证是整数还是小数
 * 其中可能包括正数和负数
 */
public class Homework02 {
    public static void main(String[] args) {
        String content = "-01";
//        String reg = ".+\\..*";
        String reg = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        if (content.matches(reg)) {
            System.out.println(content + " 是整数或小数");
        } else {
            System.out.println(content + " 不是整数或小数");
        }
    }
}
