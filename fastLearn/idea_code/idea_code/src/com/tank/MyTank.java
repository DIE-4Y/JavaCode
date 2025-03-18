package com.tank;

import java.util.Vector;

/*
 * 我的坦克
 */
public class MyTank extends Tank {
//    private Bullet bullet = null;
    private Vector<Bullet> bullets = new Vector<>();

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public MyTank(int x, int y) {
        super(x, y);
        setDirection(8);
    }

    //发射子弹功能
    public void shoot() {
        //子弹最多5个
        if (bullets.size() == 5) {
            return;
        }
        Bullet bullet = null;
        //创建子弹
        switch (getDirection()) {
            case 8:// 上
                bullet = new Bullet(getX() + 20, getY(), getDirection());
                break;
            case 2:// 下
                bullet = new Bullet(getX() + 20, getY() + 60, getDirection());
                break;
            case 4:// 左
                bullet = new Bullet(getX(), getY() + 20, getDirection());
                break;
            case 6:// 右
                bullet = new Bullet(getX() + 60, getY() + 20, getDirection());
                break;
        }
        bullets.add(bullet);
        System.out.println("子弹加入成功"+bullets);
        new Thread(bullet).start();
    }
}
