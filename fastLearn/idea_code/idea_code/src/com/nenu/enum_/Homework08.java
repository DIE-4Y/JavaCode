package com.nenu.enum_;

/*
    枚举 switch 遍历枚举对象
    case后边直接加枚举的属性
 */
public class Homework08 {
    public static void main(String[] args) {
        Color[] colors = Color.values();
        colors[2].show();
        switch (colors[2]){
            case RED:
                System.out.println("匹配到红色");break;
            case BLUE:
                System.out.println("匹配到蓝色");break;
            case GREEN:
                System.out.println("匹配到绿色");break;
            case BLACK:
                System.out.println("匹配到黑色");break;
            case YELLOW:
                System.out.println("匹配到黄色");break;
        }
    }
}

interface ColorInterface{
    void show();
}

enum Color implements ColorInterface {
    RED(255, 0, 0),BLUE(0,0,255),
    BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性值为>>:" + redValue + " "+ blueValue+ " "+ greenValue);
    }
}