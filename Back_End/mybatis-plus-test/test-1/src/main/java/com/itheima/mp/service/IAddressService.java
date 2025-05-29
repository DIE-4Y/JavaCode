package com.itheima.mp.service;

import com.itheima.mp.domain.po.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.vo.AddressVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author die-4y
 * @since 2025-05-29
 */
public interface IAddressService extends IService<Address> {

    AddressVO queryAddressById(Long id);
}
