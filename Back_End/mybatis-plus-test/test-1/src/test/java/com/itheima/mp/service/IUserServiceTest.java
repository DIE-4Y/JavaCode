package com.itheima.mp.service;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void pageInterceptorTest(){
        int pageNum = 1, pageSize = 2;

        Page<User> page = Page.of(pageNum, pageSize);
        //排序规则
        page.addOrder(new OrderItem("balance", true));
        page.addOrder(new OrderItem("id", true));

        //分页查询开始
        userService.page(page);

        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        List<User> records = page.getRecords();
        records.forEach(System.out::println);


    }
}
