package com.tank;

import java.io.Serializable;

/**
 * 基本坦克
 */
public class Tank implements Serializable {
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

    /**
     * 根据当前坦克方向判断是否将于目标坦克碰撞
     * 若碰撞返回true 否则返回false
     */
    public boolean isTouched(Tank tank) {
        switch (direction) {
            case 8: //上
                if (tank.getDirection() == 8 || tank.getDirection() == 2) { //目标坦克方向是上下
                    // 坦克左上角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 40
                            && y >= tank.getY() && y <= tank.getY() + 60) {
                        return true;
                    }
                    // 坦克右上角在目标范围
                    if (x + 40 >= tank.getX() && x + 40 <= tank.getX() + 40
                            && y >= tank.getY() && y <= tank.getY() + 60) {
                        return true;
                    }
                } else { //目标坦克方向是左右
                    // 坦克左上角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 60
                            && y >= tank.getY() && y <= tank.getY() + 40) {
                        return true;
                    }
                    // 坦克右上角在目标范围
                    if (x + 40 >= tank.getX() && x + 40 <= tank.getX() + 60
                            && y >= tank.getY() && y <= tank.getY() + 40) {
                        return true;
                    }
                }
                return false;
            case 2: //下
                if (tank.getDirection() == 8 || tank.getDirection() == 2) { //目标坦克方向是上下
                    // 坦克左下角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 40
                            && y + 60 >= tank.getY() && y + 60 <= tank.getY() + 60) {
                        return true;
                    }
                    // 坦克右下角在目标范围
                    if (x + 40 >= tank.getX() && x + 40 <= tank.getX() + 40
                            && y + 60 >= tank.getY() && y + 60 <= tank.getY() + 60) {
                        return true;
                    }
                } else { //目标坦克方向是左右
                    // 坦克左下角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 60
                            && y + 60 >= tank.getY() && y + 60 <= tank.getY() + 40) {
                        return true;
                    }
                    // 坦克右下角在目标范围
                    if (x + 40 >= tank.getX() && x + 40 <= tank.getX() + 60
                            && y + 60 >= tank.getY() && y + 60 <= tank.getY() + 40) {
                        return true;
                    }
                }
                return false;
            case 4: //左
                if (tank.getDirection() == 8 || tank.getDirection() == 2) { //目标坦克方向是上下
                    // 坦克左上角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 40
                            && y >= tank.getY() && y <= tank.getY() + 60) {
                        return true;
                    }
                    // 坦克左下角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 40
                            && y + 40 >= tank.getY() && y + 40 <= tank.getY() + 60) {
                        return true;
                    }
                } else { //目标坦克方向是左右
                    // 坦克左上角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 60
                            && y >= tank.getY() && y <= tank.getY() + 40) {
                        return true;
                    }
                    // 坦克左下角在目标范围
                    if (x >= tank.getX() && x <= tank.getX() + 60
                            && y + 40 >= tank.getY() && y + 40 <= tank.getY() + 40) {
                        return true;
                    }
                }
                return false;
            case 6: //右
                if (tank.getDirection() == 8 || tank.getDirection() == 2) { //目标坦克方向是上下
                    // 坦克右上角在目标范围
                    if (x + 60 >= tank.getX() && x + 60 <= tank.getX() + 40
                            && y >= tank.getY() && y <= tank.getY() + 60) {
                        return true;
                    }
                    // 坦克右下角在目标范围
                    if (x + 60 >= tank.getX() && x + 60 <= tank.getX() + 40
                            && y + 40 >= tank.getY() && y + 40 <= tank.getY() + 60) {
                        return true;
                    }
                } else { //目标坦克方向是左右
                    // 坦克左上角在目标范围
                    if (x + 60 >= tank.getX() && x + 60 <= tank.getX() + 60
                            && y >= tank.getY() && y <= tank.getY() + 40) {
                        return true;
                    }
                    // 坦克右下角在目标范围
                    if (x + 60 >= tank.getX() && x + 60 <= tank.getX() + 60
                            && y + 40 >= tank.getY() && y + 40 <= tank.getY() + 40) {
                        return true;
                    }
                }
                return false;
        }
        return false;
    }

}
