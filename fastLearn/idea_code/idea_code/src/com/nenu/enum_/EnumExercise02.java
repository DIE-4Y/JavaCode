package com.nenu.enum_;

public class EnumExercise02 {
    public static void main(String[] args) {
        Week monday = Week.MONDAY;
        Week[] week = Week.values();

        //增强for 针数组的每个元素进行循环
        System.out.println("所有星期如下>>:");
        for (Week day: week){
            System.out.println(day.getName());
        }
    }
}


enum Week {
    MONDAY("星期一", "每周第一天"), TUESDAY("星期二", "每周第二天"),
    WEDNESDAY("星期三", "每周第三天"), THURSDAY("星期四", "每周第四天"),
    FRIDAY("星期五", "每周第五天"), SATURDAY("星期六", "每周第六天"),
    SUNDAY("星期天", "每周第七天");

    private String name;
    private String des;

    Week() {
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    private Week(String name, String des) {
        this.name = name;
        this.des = des;
    }
}