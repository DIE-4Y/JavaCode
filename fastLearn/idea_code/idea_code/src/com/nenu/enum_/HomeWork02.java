package com.nenu.enum_;

public class HomeWork02 {
    public static void main(String[] args) {
        int num1 = Frock.getNextNum();
        int num2 = Frock.getNextNum();
        System.out.println("序号1是：" + num1);
        System.out.println("序号2是：" + num2);
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println("Frock1 num>>: "+frock1.getSerialNumber());
        System.out.println("Frock2 num>>: "+frock2.getSerialNumber());
        System.out.println("Frock3 num>>: "+frock3.getSerialNumber());
    }
}

class Frock {
    private static int currentNum = 100000;
    private int serialNumber;

    public int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }


}
