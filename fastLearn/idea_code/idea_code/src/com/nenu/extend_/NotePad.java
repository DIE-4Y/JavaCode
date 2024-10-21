package com.nenu.extend_;

public class NotePad extends Computer{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NotePad(String cpu, int rom, int disk, String color) {
        super(cpu, rom, disk);
        this.color = color;
    }

    public NotePad(String color) {
        this.color = color;
    }

    public NotePad() {
    }

    public void getInform(){
        System.out.println(getDetails() + ",color:" + color);
    }
}
