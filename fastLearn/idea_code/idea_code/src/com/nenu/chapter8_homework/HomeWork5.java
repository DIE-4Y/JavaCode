package com.nenu.chapter8_homework;

import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.plugin2.applet.FXAppletSecurityManager;

public class HomeWork5 {
    public static void main(String[] args) {

        YuanGong wang = new Farmer();
        Farmer Wang = (Farmer) wang;
        GongRen ma = new GongRen();
        YuanGong  niu = ma;

        YuanGong zhang = new YuanGong("张三", 2000);
        GongRen gongRen = new GongRen("周八", 2050);
        Farmer farmer = new Farmer("李四", 2100);
        Waiter waiter = new Waiter("王五", 2200);
        JiaoShi jiaoShi = new JiaoShi("赵二", 6000, 500, 20);
        Scientist scientist = new Scientist("孙七", 25000, 400000);
        Show show = new Show();
        show.showSalary(zhang);
        show.showSalary(gongRen);
        show.showSalary(farmer);
        show.showSalary(waiter);
        show.showSalary(jiaoShi);
        show.showSalary(scientist);
    }
}

class Show {
    public void showSalary(YuanGong y) {
        if (y instanceof GongRen) {
            System.out.println("工人" + y.getName() + "的工资为" + y.getSalary());
        } else if (y instanceof Farmer) {
            System.out.println("农民" + y.getName() + "的工资为" + y.getSalary());
        } else if (y instanceof Waiter) {
            System.out.println("服务生" + y.getName() + "的工资为" + y.getSalary());
        } else if (y instanceof JiaoShi) {
            System.out.println("教师" + y.getName() + "的工资为" + y.getSalary());
        } else if (y instanceof Scientist) {
            System.out.println("科学家" + y.getName() + "的工资为" + y.getSalary());
        } else {
            System.out.println("员工" + y.getName() + "的工资为" + y.getSalary());
        }
    }
}