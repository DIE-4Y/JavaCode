package com.nenu.smallcharge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChargeAPP {
    Scanner mysancner = new Scanner(System.in);
    private boolean loop = true;
    private double balance = 0;
    private double money = 0;
    private String key = "";
    Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh-mm");
    String detail = "--------零钱通明细--------\n";

    public void showMenu() {

        do {
            System.out.println("--------零钱通菜单--------");
            System.out.println("\t\t1菜单明细");
            System.out.println("\t\t2收入入账");
            System.out.println("\t\t3消费明细");
            System.out.println("\t\t4退    出");
            System.out.println("\t\t请输入1-4");
            key = mysancner.next();
            switch (key) {
                case "1":
                    this.showDetail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误");
            }
        } while (loop);
        System.out.println("退出零钱通~~");
    }

    public void showDetail() {
        System.out.println(detail);
    }

    public void income() {
        System.out.println("请输入金额");
        date = new Date();
        money = mysancner.nextDouble();
        if (money < 0) {
            System.out.println("输入金额错误");
            return;
        }
        balance += money;
        detail += "收益入账：" + "\t+" + money + "\t" + sdf.format(date) + "\t余额：" + balance + "\n";
    }

    public void pay() {
        System.out.println("请输入消费项目");
        String activity = mysancner.next();
        date = new Date();
        System.out.println("请输入消费金额");
        money = mysancner.nextDouble();
        if (money > balance) {
            System.out.println("消费金额大于账户余额 当前账户余额为" + balance);
            return;
        }
        if (money < 0) {
            System.out.println("输入金额有误");
            return;
        }
        balance -= money;
        detail += activity + "\t-" + money + "\t" + sdf.format(date) + "\t余额：" + balance + "\n";
    }

    public void exit() {
        System.out.println("\t\t4退    出");
        char ch;
        while (true) {
            System.out.println("\5确认退出吗？y/n");
            ch = mysancner.next().charAt(0);
            if (ch == 'y' || ch == 'n') {
                break;
            }
            System.out.println("输入错误");
        }
        if (ch == 'y') {
            loop = false;
        }
    }
}
