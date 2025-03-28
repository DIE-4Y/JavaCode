package com.multipleUserChat.client.utils;

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

    public static String getString(int len) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        return len > s.length() ? s : scanner.next().substring(len);
    }

    public static int getNum() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("请输入数字：");
            scanner.next();
        }
        int id = scanner.nextInt();
        return id;
    }
}
