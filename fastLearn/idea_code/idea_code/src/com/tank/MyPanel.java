package com.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {

    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();  //Vector线程安全用于存放敌方坦克
    Vector<Node> nodes = new Vector<>();
    int enemyCount = 3;

    public MyPanel(String key) {
        Recorder.setEnemyTanks(enemyTanks);
        //我的坦克位置初始化
        this.myTank = new MyTank(100, 300);
        myTank.setSpeed(4);
        switch (key) {
            case "0":
                //敌方坦克位置初始化
                for (int i = 1; i <= enemyCount; i++) {
                    EnemyTank enemyTank = new EnemyTank((100 * i), 0);
                    enemyTank.setEnemyTanks(enemyTanks);
                    //设置坦克方向
                    enemyTank.setDirection(2);
                    //启动坦克线程
                    new Thread(enemyTank).start();
                    //初始化的时候添加子弹
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
                    enemyTank.getBullets().add(bullet);
                    new Thread(bullet).start();     //启动线程
                    enemyTanks.add(enemyTank);
                }
                break;
            case "1":
                nodes = Recorder.getAllEnemyTank();
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    if (node != null) {
                        EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                        enemyTank.setEnemyTanks(enemyTanks);
                        //设置坦克方向
                        enemyTank.setDirection(node.getDirection());
                        //启动坦克线程
                        new Thread(enemyTank).start();
                        //初始化的时候添加子弹
                        Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
                        enemyTank.getBullets().add(bullet);
                        new Thread(bullet).start();     //启动线程
                        enemyTanks.add(enemyTank);
                    }
                }
                break;
            default:
                System.out.println("输入错误~~~");
        }

    }

    //侧边栏画上记录
    public void showInfo(Graphics g) {
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累计击毁坦克数", 1020, 30);

        drawTank(1020, 60, 8, 1, g);
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankCount() + "", 1080, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        //背景填充颜色， 默认为黑色
        g.fillRect(0, 0, 1000, 750);
        //判断我的坦克是否存活
        if (myTank.getLive()) {
            //调用画坦克的方法 -- 从我的坦克获取坐标
            drawTank(myTank.getX(), myTank.getY(), myTank.getDirection(), 0, g);
            //画子弹
            //2.多颗子弹
            for (int i = 0; i < myTank.getBullets().size(); i++) {
                Bullet bullet = myTank.getBullets().get(i);
                if (bullet != null && bullet.isLive()) {//某一个子弹可能击中后销毁
                    g.draw3DRect(bullet.getX(), bullet.getY(), 2, 2, false);
                } else {//子弹没了从集合里去掉
                    myTank.getBullets().remove(bullet);
                }
            }
//        //1.单颗子弹 条件有顺序不然会有空指针异常
//        if (myTank.getBullet() != null && myTank.getBullet().isLive()) {
//            System.out.println("子弹被调用");
//            g.draw3DRect(myTank.getBullet().getX(), myTank.getBullet().getY(), 2, 2, false);
//        }
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

            } else {
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
    public void hitTank(Vector<Bullet> bullets, Tank tank) {
        for (Bullet bullet : bullets) {
            if (bullet != null && bullet.isLive()) {
                switch (tank.getDirection()) {
                    case 8:
                    case 2:
                        if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 40
                                && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
                            bullet.setLive(false);
                            tank.setLive(false);
                            if (tank instanceof EnemyTank) {
                                Recorder.addEnemyTankCount();
                            }
                        }
                        break;
                    case 4:
                    case 6:
                        if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 60
                                && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 40) {
                            bullet.setLive(false);
                            tank.setLive(false);
                            if (tank instanceof EnemyTank) {
                                Recorder.addEnemyTankCount();
                            }
                        }
                }
            }
        }
    }
//    public void hitTank(Bullet bullet, Tank tank) {
//        switch (tank.getDirection()) {
//            case 8:
//            case 2:
//                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 40
//                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
//                    bullet.setLive(false);
//                    tank.setLive(false);
//                }
//                break;
//            case 4:
//            case 6:
//                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 60
//                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 40) {
//                    bullet.setLive(false);
//                    tank.setLive(false);
//                }
//        }
//    }

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
            //重绘之前判断是否击中坦克--
            //1.敌方坦克是否被击中
            if (!myTank.getBullets().isEmpty() && myTank.getLive()) {
                for (EnemyTank enemyTank : enemyTanks) {
                    hitTank(myTank.getBullets(), enemyTank);
                }
            }
            //2.我方坦克是否被击中
            if (myTank.getLive()) {  //我方坦克存活再判断
                for (EnemyTank enemyTank : enemyTanks) {
                    if (enemyTank.getLive()) {
                        hitTank(enemyTank.getBullets(), myTank);
                    }
                }
            }
            this.repaint();
        }
    }
}
