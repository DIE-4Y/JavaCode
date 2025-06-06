package com.manhanlou.utils;


import org.junit.Test;

import java.util.Scanner;

public class Util {

    public static char getChar() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if (str.length() != 1) {
            boolean loop = true;
            do {
                System.out.println("请只输入一个字符：");
                str = scanner.next();
                if (str.length() == 1) {
                    loop = false;
                }
            } while (loop);
        }
        return str.charAt(0);
    }


    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int getNum() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("请输入数字：");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static char readConfirm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("确认你的选择(Y/N)");
        while (true) {
            String s = scanner.next();
            char c = s.toUpperCase().charAt(0);
            if (c == 'Y' || c == 'N') {
                return c;
            } else {
                System.out.println("选择错误 请重新输入");
            }
        }
    }

}
