package com.nenu.jdbc_.test;

import com.nenu.jdbc_.JDBCUtilsByDruid;
import com.nenu.jdbc_.dao.GoodsDao;
import com.nenu.jdbc_.domain.Goods;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        TestDao testDao = new TestDao();
        testDao.testGoodsDao();
    }

    public void testGoodsDao() {
        GoodsDao goodsDao = new GoodsDao();
        //多行查询
        String sql = "select * from goods where id >= ?";
        List<Goods> goods = goodsDao.queryMulti(sql, Goods.class, 10);
        System.out.println("\n查询到的商品为：");
        System.out.println(goods);
        System.out.println("===============\n");
        //单行查询
        sql = "select * from goods where id = ?";
        Goods goods1 = goodsDao.querySingle(sql, Goods.class, 10);
        System.out.println("\n查询到的商品为：");
        System.out.println(goods1);
        System.out.println("===============\n");
        //添加
//        sql = "insert into goods values(?,?,?)";
//        int update = goodsDao.update(sql, 40, "iqoo", 2200);
//        System.out.println(update > 0 ? "货品添加成功" : "货品添加失败");
//        System.out.println("===============\n");
        //修改
//        sql = "update goods set price = ? where id = 4";
//        int update = goodsDao.update(sql, 2100);
//        System.out.println(update > 0 ? "修改成功" : "修改失败");
//        System.out.println("===============\n");
        //删除
        sql = "delete from goods where id = ?";
        int update = goodsDao.update(sql, 40);
        System.out.println(update > 0 ? "删除成功" : "删除失败");
        System.out.println("===============\n");
    }
}
