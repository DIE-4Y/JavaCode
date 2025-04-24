package com.manhanlou.domain;

public class DiningTable {
    Integer id;
    String state;
    String orderName;
    String oderTel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOderTel() {
        return oderTel;
    }

    public void setOderTel(String oderTel) {
        this.oderTel = oderTel;
    }

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String oderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.oderTel = oderTel;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + state;
    }
}
