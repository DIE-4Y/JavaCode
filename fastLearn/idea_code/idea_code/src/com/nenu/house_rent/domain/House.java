package com.nenu.house_rent.domain;

public class House {
    private int id;
    private String name;
    private String phone;
    private String address;
    private double rent;
    private String status;

    public House() {
    }

    public House(int id, String name, String phone, String address, double rent, String status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id +
                "\t\t\t" + name +
                "\t\t" + phone +
                "\t" + address +
                "\t\t" + rent +
                "\t\t" + status;
    }
}
