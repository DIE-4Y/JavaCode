package test;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args)
    {
        int a, b, max;
        System.out.println("请输入两个整数");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        max = a > b ? a : b ;
        System.out.println(max);
    }
}
