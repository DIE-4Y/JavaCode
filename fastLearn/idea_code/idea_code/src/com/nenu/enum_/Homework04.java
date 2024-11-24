package com.nenu.enum_;

/*
    匿名内部类的使用
 */
public class Homework04 {
    public static void main(String[] args) {
        Cellphone.testWork(new IF(){
            public void work() {
                System.out.println("匿名内部类重写work方法~~");
            }
        });
    }
}

interface IF{
    void work();
}

class Cellphone{
    public static void testWork(IF phone){
        phone.work();
    }
}