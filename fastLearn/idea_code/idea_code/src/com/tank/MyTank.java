package com.tank;

/*
 * 我的坦克
 */
public class MyTank extends Tank {
    private Bullet bullet = null;

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public MyTank(int x, int y) {
        super(x, y);
        setDirection(8);
    }

    // 发射子弹功能
    public void shoot() {
        // 创建子弹
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
        new Thread(bullet).start();
    }
}
