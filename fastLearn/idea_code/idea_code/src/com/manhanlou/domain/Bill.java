package com.manhanlou.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double price;
    private Integer diningTable;
    private LocalDateTime billDate;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(Integer diningTable) {
        this.diningTable = diningTable;
    }

    public LocalDateTime getbillDate() {
        return billDate;
    }

    public void setbillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer menuId, Integer nums, Double price, Integer diningTable, LocalDateTime billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.price = price;
        this.diningTable = diningTable;
        this.billDate = billDate;
        this.state = state;
    }

    @Override
    public String toString() {
        return id + "\t\t" +
                menuId + "\t\t" +
                nums + "\t\t" +
                price + "\t\t" +
                diningTable + "\t\t" +
                billDate + "\t\t" +
                state;
    }
}
