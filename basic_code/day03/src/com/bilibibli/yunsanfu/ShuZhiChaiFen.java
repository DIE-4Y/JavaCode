package com.bilibibli.yunsanfu;
import java.net.SocketTimeoutException;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.Scanner;
public class ShuZhiChaiFen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数");
        int n = sc.nextInt();
        int g = n % 10;
        System.out.println("个位是："+g);
        n = n / 10;
        g = n % 10;
        System.out.println("十位是："+g);
        n = n / 10;
        g = n % 10;
        System.out.println("百位是："+g);
        byte b1 = 20;
        byte b2 = 20;
        byte k = (byte) (b1 + b2);
        System.out.println(k);
    }
}
