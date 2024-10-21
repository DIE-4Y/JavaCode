package com.nenu.extend_;

public class Pc extends Computer {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void showInform() {
        System.out.println(getDetails() + ";brand:" + brand);
    }

    public Pc() {
    }

    public Pc(String cpu, int rom, int disk, String brand) {
        super(cpu, rom, disk);
        this.brand = brand;
    }
}
