package com.nenu.Thread_;

import java.util.Scanner;

/*
 * main方法中启动2个线程
 * 第一个子线程无限循环，随机输出1-100内的数字，
 * 第二个子线程从键盘读入Q 第一个子线程结束
 * 通知方式实现
 */
public class Homework01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
        new T2(t1).start();
    }
}

class T1 extends Thread {
    public Boolean getLoop() {
        return loop;
    }

    public void setLoop(Boolean loop) {
        this.loop = loop;
    }

    Boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println("T1:"+(int) (Math.random() * 100 + 1));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class T2 extends Thread {
    private T1 t1;

    public T2(T1 t1) {
        this.t1 = t1;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q/q，退出程序:>>");
            char ch = scanner.next().toUpperCase().charAt(0);
            if (ch == 'Q') {
                System.out.println("T2线程退出...");
                t1.setLoop(false);
                break;
            }
        }
    }
}
