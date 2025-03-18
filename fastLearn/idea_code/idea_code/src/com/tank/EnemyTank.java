package com.tank;

import java.util.Vector;

public class EnemyTank extends Tank{
    private Vector<Bullet> bullets = new Vector<>();

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
}
