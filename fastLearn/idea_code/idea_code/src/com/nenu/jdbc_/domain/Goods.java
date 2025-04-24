package com.nenu.jdbc_.domain;

/**
 * 对应数据库的Goods表
 */
public class Goods {
    private Integer id;
    private String goods_name;
    private Double price;

    public Goods(Integer id, String goods_name, Double price) {
        this.id = id;
        this.goods_name = goods_name;
        this.price = price;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getgoods_name() {
        return goods_name;
    }

    public void setgoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", price=" + price +
                '}';
    }
}
