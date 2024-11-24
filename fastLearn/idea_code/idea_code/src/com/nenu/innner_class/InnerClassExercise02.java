package com.nenu.innner_class;


/**
 * 匿名内部类作参数
 */

public class InnerClassExercise02 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();

        //这个编译类型是Bell 运行类型是 匿名内部类
        //并自动生成一个对象
        //由于匿名内部类重写了ring alarmclock动态绑定
        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了~~");
            }
        });

        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴该上课了~~");
            }
        });
    }
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarmclock(Bell bell) {
        bell.ring();
    }
}