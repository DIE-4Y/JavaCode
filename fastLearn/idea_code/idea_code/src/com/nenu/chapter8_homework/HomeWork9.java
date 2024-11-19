package com.nenu.chapter8_homework;

public class HomeWork9 {
    public static void main(String[] args) {

    }
}

class Point{
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabelPoint extends Point{
    private String label;

    public LabelPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }
    
}
