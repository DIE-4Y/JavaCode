package com.itheima.mp.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void deductBalance(Long id, Integer money) {
        User user = getById(id);

        if (user == null || user.getStatus()==2) {
            throw new RuntimeException("用户信息异常");
        }

        if(user.getBalance() < money){
            throw new RuntimeException("金额不足");
        }

        userMapper.deductBalance(id, money);
    }
}
