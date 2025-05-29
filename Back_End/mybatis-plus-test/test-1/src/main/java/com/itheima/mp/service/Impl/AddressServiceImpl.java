package com.itheima.mp.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.mapper.AddressMapper;
import com.itheima.mp.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author die-4y
 * @since 2025-05-29
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Override
    public AddressVO queryAddressById(Long id) {
        User user = Db.lambdaQuery(User.class).eq(User::getId, id).one();
        if (user == null || user.getStatus() ==  2){
            throw new RuntimeException("用户状态异常");
        }

        Address address = lambdaQuery().eq(Address::getUserId, id).eq(Address::getIsDefault, true).one();

        return BeanUtil.copyProperties(address, AddressVO.class);
    }
}
