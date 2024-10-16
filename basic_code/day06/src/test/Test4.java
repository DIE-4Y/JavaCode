package test;

public class Test4 {
    public static void main(String[] args) {
        compare((byte) 10, (byte) 20);
        compare((short) 10, (short) 20);
    }
    public static void compare(byte num1, byte num2){
        System.out.println(num1 == num2);
    }
    public static void compare(short num1, short num2){
        System.out.println(num1 == num2);
    }
    public static void compare(int  num1, int num2){
        System.out.println(num1 == num2);
    }
    public static void compare(double num1, double num2){
        System.out.println(num1 == num2);
    }
    public static void compare(long num1, long num2){
        System.out.println(num1 == num2);
    }
}
