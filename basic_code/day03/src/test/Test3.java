package test;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数");
        int a = sc.nextInt(), b = sc.nextInt();
        boolean flag = false;
        if((a == 6) || (b == 6) || ((a + b) % 6 == 0))
            flag = true;
        System.out.println(flag);
    }
}
