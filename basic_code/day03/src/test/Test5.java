package test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int weight_a, weight_b;
        System.out.println("请输入两只老虎的体重");
        weight_a = sc.nextInt();
        weight_b = sc.nextInt();
        String str =weight_a > weight_b ? "相同" : "不同";
        System.out.println(str);
    }
}
