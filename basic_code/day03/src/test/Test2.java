package test;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入我们衣服的时髦度：");
        int me = sc.nextInt();
        System.out.println("请输入对象衣服的时髦度：");
        int her = sc.nextInt();
            System.out.println("是否成功：" + (me > her));
    }
}
