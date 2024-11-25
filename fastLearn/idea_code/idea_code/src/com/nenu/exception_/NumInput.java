package com.nenu.exception_;

import java.util.Scanner;

/*
    使用try-catch实现数字输入函数
 */

public class NumInput {
    public static void main(String[] args) {
        System.out.println("输入的数字为>>:" + getNum());
    }

    public static int getNum() {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入整数>>:");
        while (true){
            try {
                String strNum = scanner.next();
                num = Integer.parseInt(strNum);
                break;
            } catch (Exception e) {
                System.out.println("输入错误");
            }
        }
        return num;
    }
}
