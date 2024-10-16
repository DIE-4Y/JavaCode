package logicdemo;

import java.sql.SQLOutput;

public class LogicDemo1 {
    public static void main(String[] args){
           System.out.println(true && true);
           System.out.println(true & false);
           System.out.println(false & false);
           System.out.println(true || true);
           System.out.println(false || true);
           System.out.println(false || false);
           int a = 10, b = 20;
           boolean result = ++a < 5 && b-- > 10;
           System.out.println(result);
           System.out.println(a);
           System.out.println(b);
           result = ++a < 5 & b-- > 10;
           System.out.println(result);
           System.out.println(a);
           System.out.println(b);
    }
}
