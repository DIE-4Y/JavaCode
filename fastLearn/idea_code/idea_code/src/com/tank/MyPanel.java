package com.tank;

import com.sun.corba.se.impl.orb.ParserTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {

    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();  //Vector线程安全用于存放敌方坦克
    int enemyCount = 3;

    public MyPanel() {
        //我的坦克位置初始化
        this.myTank = new MyTank(100, 100);
        //敌方坦克位置初始化
        for (int i = 1; i <= enemyCount; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * i), 0);
            //初始化的时候添加子弹
            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            enemyTank.getBullets().add(bullet);
            new Thread(bullet).start();     //启动线程
            enemyTanks.add(enemyTank);
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //背景填充颜色， 默认为黑色
        g.fillRect(0, 0, 1000, 750);
        //调用画坦克的方法 -- 从我的坦克获取坐标
        drawTank(myTank.getX(), myTank.getY(), myTank.getDirection(), 0, g);
        //画子弹 条件有顺序不然会有空指针异常
        if (myTank.getBullet() != null && myTank.getBullet().isLive()) {
            System.out.println("子弹被调用");
            g.draw3DRect(myTank.getBullet().getX(), myTank.getBullet().getY(), 2, 2, false);
        }
        //画敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //绘制敌方坦克之前必须先判断是否存活
            if (enemyTank.getLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirection(), 1, g);
                //画子弹
                for (int j = 0; j < enemyTank.getBullets().size(); j++) {
                    //取出子弹
                    Bullet bullet = enemyTank.getBullets().get(j);
                    //绘制子弹 有条件
                    if (bullet.isLive()) {
                        g.draw3DRect(bullet.getX(), bullet.getY(), 2, 2, false);
                    } else {
                        //移除子弹
                        enemyTank.getBullets().remove(bullet);
                    }
                }

            }else {
                enemyTanks.remove(enemyTank);
            }
        }
    }

    //画坦克
    public void drawTank(int x, int y, int direction, int type, Graphics g) {
        //System.out.println("画坦克方法被调用");
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
                g.fill3DRect(x, y + 30, 60, 10, false);//右履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克主体
                g.drawOval(x + 20, y + 10, 20, 20);//坦克盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//坦克炮筒
                break;
            case 6:         //朝向右方
                g.fill3DRect(x, y, 60, 10, false);//左履带
                g.fill3DRect(x, y + 30, 60, 10, false);//右履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克主体
                g.drawOval(x + 20, y + 10, 20, 20);//坦克盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//坦克炮筒
                break;
            default:
                System.out.println("方向不正确");
        }
    }

    //判断子弹是否击中坦克 如果击中修改坦克和子弹的属性
    public void hitTank(Bullet bullet, Tank tank) {
        switch (tank.getDirection()) {
            case 8:
            case 2:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 40
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
//                    System.out.println("=============敌方已被击中=============");
                    bullet.setLive(false);
                    tank.setLive(false);
                }
                break;
            case 4:
            case 6:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 60
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 40) {
//                    System.out.println("=============敌方已被击中=============");
                    bullet.setLive(false);
                    tank.setLive(false);
                }
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
        // 按J发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            myTank.shoot();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //重绘之前判断是否击中坦克--敌方坦克是否被击中
            if (myTank.getBullet() != null && myTank.getLive()) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(myTank.getBullet(), enemyTank);
                }
            }
            this.repaint();
        }
    }
}
