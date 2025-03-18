package com.tank;

/**
 * 基本坦克
 */
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed;
    private Boolean isLive = true;

    public Boolean getLive() {
        return isLive;
    }

    public void setLive(Boolean live) {
        isLive = live;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp() {
        if (y > 0)
            y--;
    }

    public void moveDown() {
        if (y + 60 < 750)
            y++;
    }

    public void moveLeft() {
        if (x > 0)
            x--;
    }

    public void moveRight() {
        if (x + 60 < 1000)
            x++;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
