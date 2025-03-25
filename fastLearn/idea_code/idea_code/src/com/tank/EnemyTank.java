package com.tank;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    private Vector<Bullet> bullets = new Vector<>();
    private Vector<EnemyTank> enemyTanks = null;

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
        setDirection(2);
    }

    //判断是否敌方坦克相互碰撞, 如果碰撞返回true 停止执行 否则 返回false
    public boolean isTouchEnemyTank() {
        //Vector里的数据会改变不用增强for
//        for (EnemyTank enemyTank : enemyTanks) {
//            if (this != enemyTank) {
//                if (isTouched(enemyTank)) {
//                    return true;
//                }
//            }
//        }
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (this != enemyTank) {
                if (isTouched(enemyTank)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void run() {
        while (true) {
            Bullet bullet = null;
            //小于几就可以发射几颗子弹
            if (getLive() && bullets.size() < 2) {
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
                new Thread(bullet).start();
            }
            //移动
            switch (getDirection()) {
                case 8:
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank()) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //随机转向
            int direct = ((int) (Math.random() * 4 + 1)) * 2;
            setDirection(direct);
            if (!getLive()) {
                break;
            }
        }
    }
}
