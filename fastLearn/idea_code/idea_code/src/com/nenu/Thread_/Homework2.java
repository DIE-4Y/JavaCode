package com.nenu.Thread_;

/*
 * 一共 10000元，两个线程每次取走1000元
 * 不能使剩余的钱少于0
 */
public class Homework2 {
    public static void main(String[] args) {
        new T3().start();
        new T3().start();
//        T3 t3 = new T3();
//        Thread thread1 = new Thread(t3);
//        Thread thread2 = new Thread(t3);
//        thread1.start();
//        thread2.start();
    }
}

class T3 extends Thread {
    private static int totalMoney = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (T3.class) {
                if (totalMoney < 1000) {
                    System.out.println("钱已取完");
                    break;
                }
                totalMoney -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000元,当前还剩：" + totalMoney);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
//class T3 implements Runnable {
//    private int totalMoney = 10000;
//
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (this) {
//                if (totalMoney < 1000) {
//                    System.out.println("钱已取完");
//                    break;
//                }
//                totalMoney -= 1000;
//                System.out.println(Thread.currentThread().getName() + "取出1000元,当前还剩：" + totalMoney);
//
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}