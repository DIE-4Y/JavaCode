package com.nenu.stringbuffer_;

import java.util.Scanner;

/*
    StringBuffer处理字符串
    将输入的价格整数位每三位添加一个 , 隔开
 */

public class Exercise01 {
    public static void main(String[] args) {
        String price;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入名称>>:");
        name = scanner.next();
        System.out.print("请输入价格>>:");
        price = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(price);
        for (int index = stringBuffer.indexOf("."); index - 3 > 0; index -= 3) {
            stringBuffer = stringBuffer.insert(index-3, ',');
        }
        System.out.println("物品\t\t价格");
        System.out.println(name + "\t\t" + stringBuffer);
    }
}
