package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper extends BaseMapper<User>{

    void updateBalanceByCumstom(@Param(Constants.WRAPPER) LambdaUpdateWrapper<User> wrapper,@Param("amount") int amount);

    @Update("update user set balance = balance-#{balance} where id = #{id}")
    void deductBalance(Long id, Integer balance);

//    void saveUser(User user);
//
//    void deleteUser(Long id);
//
//    void updateUser(User user);
//
//    User queryUserById(@Param("id") Long id);
//
//    List<User> queryUserByIds(@Param("ids") List<Long> ids);
}
