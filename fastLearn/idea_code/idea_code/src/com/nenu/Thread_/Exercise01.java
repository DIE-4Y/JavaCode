package com.nenu.Thread_;

public class Exercise01 {
    public static void main(String[] args) throws InterruptedException {

        int count = 10;
        H h = new H();
        /*
        目标：主线程执行5次后启动子线程，子线程执行完毕执行主线程
         */
        for (int i = 1; i <= count; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i == 5) {
                Thread t1 = new Thread(h);
                t1.start();
                t1.join();
            }
        }
        System.out.println("主线程结束...");
    }
}


class H implements Runnable {
    private int count = 10;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            try {
                System.out.println("hello " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("子线程结束...");
    }
}