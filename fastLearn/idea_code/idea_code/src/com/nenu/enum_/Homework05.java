package com.nenu.enum_;

/*
    成员内部类的使用
    创建内部类时要小心 外部类对象.new 内部类();
 */
public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        b.show();
    }
}

class A{
    private String name = "小明";
    class B{
        private final String name = "小强";

        public void show(){
            System.out.println("B的name = "+name);
            System.out.println("A的name = "+A.this.name);
        }
    }
}
