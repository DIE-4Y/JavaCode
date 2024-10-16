package homework;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, ge, shi, bai, sum;
        System.out.println("请输入一个三位数");
        num = sc.nextInt();
        ge = num % 10;
        num /= 10;
        shi = num % 10;
        num /= 10;
        bai = num % 10;
        num /= 10;
        sum = ge + shi + bai;
        System.out.println(sum);
    }
}
