package com.tank;

/*
 * 子弹对象
 * 1.碰到边界销毁
 * 2.碰到敌方坦克销毁 todo
 */
public class Bullet implements Runnable {
    private int x;
    private int y;
    private int direction;
    private int speed = 2;
    private boolean isLive = true;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            // 移动
            switch (getDirection()) {
                case 8:
                    y -= speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 4:
                    x -= speed;
                    break;
                case 6:
                    x += speed;
                    break;
            }
//            System.out.println("子弹位置(" + x + "," + y + ")");
            // 休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 销毁条件
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                System.out.println("子弹销毁");
                isLive = false;
                break;
            }
        }
    }
}
