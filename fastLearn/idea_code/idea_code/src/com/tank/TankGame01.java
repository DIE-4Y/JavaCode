package com.tank;

import javax.swing.*;
import java.awt.*;

public class TankGame01 extends JFrame {

    //我的图形面板要放在JFrame上， 创立一个JPanel
    MyPanel mp = null;

    //JFrame初始化
    public TankGame01() {
        this.mp = new MyPanel();                                //初始化我的图形面板
        this.add(mp);                                           //加入我的图形 坦克、河流等
        this.addKeyListener(mp);
        this.setSize(1000, 750);                   //设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //关闭窗口关闭程序
        this.setVisible(true);                                  //设置窗口是否可见
    }

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }
}
