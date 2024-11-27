package com.nenu.exception_;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        int n1, n2;
        n1 = EcmDef.inputInt();
        n2 = EcmDef.inputInt();
        EcmDef.cal(n1, n2);
    }
}

class EcmDef {
    public static void cal(int n1, int n2) {
        int res;
        try {   //非法运算--除零
            res = n1 / n2;
            System.out.println("n2 / n2 = " + res);
        } catch (ArithmeticException e) {
            System.out.println("分母为0，不能相除");
        }
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        String input;
        int num;
        while (true) {
            try {   //输入非法错误
                System.out.print("请输入一个整数>>:");
                input = scanner.next();
                num = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("非法输入");
            }
        }
        return num;
    }
}
