package com.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankGame01 extends JFrame {

    //我的图形面板要放在JFrame上， 创立一个JPanel
    MyPanel mp = null;

    //JFrame初始化
    public TankGame01() {
        System.out.println("请输入：0.新开游戏， 1.继续游戏");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        this.mp = new MyPanel(key); //初始化我的图形面板
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);                                           //加入我的图形 坦克、河流等
        this.addKeyListener(mp);
        this.setSize(1300, 750);                   //设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //关闭窗口关闭程序
        this.setVisible(true);                                  //设置窗口是否可见
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("检测到正在关闭窗口，保存记录");
                Recorder.storeRecord();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }
}
