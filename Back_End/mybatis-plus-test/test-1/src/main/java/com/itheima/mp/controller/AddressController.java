package com.itheima.mp.controller;


import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.service.IAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author die-4y
 * @since 2025-05-29
 */
@RestController
@RequestMapping("/address")
@Slf4j
@Api(tags = "收货地址相关接口")
@RequiredArgsConstructor
public class AddressController {

    private final IAddressService iAddressService;

    @ApiOperation("根据用户id查询收货地址")
    @GetMapping("/{id}")
    public AddressVO queryAddressById(@PathVariable Long id){
        log.info("根据用户id查询收货地址");
        return iAddressService.queryAddressById(id);
    }
}
