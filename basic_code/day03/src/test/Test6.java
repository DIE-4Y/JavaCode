package test;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int max, height1, height2, height3, temp;
        System.out.println("请输入三个和尚的身高");
        height1 = sc.nextInt();
        height2 = sc.nextInt();
        height3 = sc.nextInt();
        max = height1 > height2 ? height1 : height2;
        max = max > height3 ? max : height3;
        System.out.println(max);
    }
}
