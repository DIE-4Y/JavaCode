package com.tank;

import com.sun.corba.se.impl.orb.ParserTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {

    MyTank myTank = null;

    public MyPanel() {
        //我的坦克位置初始化
        this.myTank = new MyTank(100, 100);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //背景填充颜色， 默认为黑色
        g.fillRect(0, 0, 1000, 750);
        //调用画坦克的方法 -- 从我的坦克获取坐标
        drawTank(myTank.getX(), myTank.getY(), myTank.getDirection(), 0, g);
    }


    public void drawTank(int x, int y, int direction, int type, Graphics g) {
//        System.out.println("画坦克方法被调用");
        switch (type) {
            case 0:         //0 为自己青色
                g.setColor(Color.cyan);
                break;
            case 1:         //1 为敌人黄色
                g.setColor(Color.yellow);
                break;

        }

        switch (direction) {
            case 8:         //朝上方
                g.fill3DRect(x, y, 10, 60, false);//左履带
                g.fill3DRect(x + 30, y, 10, 60, false);//右履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克主体
                g.drawOval(x + 10, y + 20, 20, 20);//坦克盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//坦克炮筒
                break;
            case 2:         //朝下方
                g.fill3DRect(x, y, 10, 60, false);//左履带
                g.fill3DRect(x + 30, y, 10, 60, false);//右履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克主体
                g.drawOval(x + 10, y + 20, 20, 20);//坦克盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//坦克炮筒
                break;
            case 4:         //朝左方
                g.fill3DRect(x, y, 60, 10, false);//左履带
                g.fill3DRect(x, y+30, 60, 10, false);//右履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克主体
                g.drawOval(x + 20, y + 10, 20, 20);//坦克盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//坦克炮筒
                break;
            case 6:         //朝向右方
                g.fill3DRect(x, y, 60, 10, false);//左履带
                g.fill3DRect(x, y+30, 60, 10, false);//右履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克主体
                g.drawOval(x + 20, y + 10, 20, 20);//坦克盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//坦克炮筒
                break;
            default:
                System.out.println("方向不正确");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(8);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(4);
            myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(6);
            myTank.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
