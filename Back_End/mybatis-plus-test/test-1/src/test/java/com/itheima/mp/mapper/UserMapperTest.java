package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
//        user.setId(5L);
        user.setUsername("Moss");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(5L);
        System.out.println("user = " + user);
    }


    @Test
    void testQueryByIds() {
        List<User> users = userMapper.selectBatchIds(List.of(1L, 2L, 3L, 4L));
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(5L);
        user.setBalance(20000);
        userMapper.updateById(user);
    }

    @Test
    void testDeleteUser() {
        userMapper.deleteById(5L);
    }

    @Test
    void testQueryWrapper(){
        //条件查询
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("id", "username", "info", "balance")
                .like("username", "o")
                .gt("balance", 2000);

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateWrapper(){
        //通过查询设置余额
        User user = new User();
        user.setBalance(2000);

        //QueryWrapper 两边都需要添加泛型
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("username", "jack");

        userMapper.update(user, wrapper);
    }

    /**
     * 改进为lambdaWrapper之后的代码
     * 避免硬编码
     */
    @Test
    void testLambdaUpdateWrapper(){
        //通过查询设置余额
        User user = new User();
        user.setBalance(2000);

        //QueryWrapper 两边都需要添加泛型
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, "jack");

        userMapper.update(user, wrapper);
    }


    @Test
    void testUpdateWrapper02(){
        //根据ids将balance-200
        List<Long> ids = Arrays.asList(1L, 2L, 5L);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>()
                .setSql("balance = balance - 200")
                .in("id", ids);

        userMapper.update(null, updateWrapper);
    }
    /**
     * lambdaWrapper改变后的代码
     */
    @Test
    void testLambdaUpdateWrapper02(){
        //根据ids将balance-200
        List<Long> ids = Arrays.asList(1L, 2L, 5L);
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>()
                .setSql("balance = balance - 200")
                .in(User::getId, ids);

        userMapper.update(null, updateWrapper);
    }

    /**
     * 自定义拼接sql
     */
    @Test
    void testCustomUpdate(){
        //根据ids将balance-200
        int amount = 200;

        List<Long> ids = Arrays.asList(1L, 2L, 5L);
        //拼接条件
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<User>()
                .in(User::getId, ids);

        userMapper.updateBalanceByCumstom(wrapper, amount);
    }
}