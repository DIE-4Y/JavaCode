package com.itheima.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@Slf4j
@Api(tags = "用户管理接口")
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;

    @PostMapping
    @ApiOperation("新增用户")
    public void saveUser(@RequestBody UserFormDTO userFormDTO){
        log.info("新增用户");
        User user = BeanUtil.copyProperties(userFormDTO, User.class);

        iUserService.save(user);
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        log.info("根据id删除用户"+id);
        iUserService.removeById(id);
    }


    @ApiOperation("根据id查询用户")
    @GetMapping("/{id}")
    public UserVO queryById(@PathVariable Long id){
        log.info("根据id查询用户");
        User user = iUserService.getById(id);
        return BeanUtil.copyProperties(user, UserVO.class);
    }

    @ApiOperation("根据id批量查询用户")
    @GetMapping
    public List<UserVO> queryByIds(@RequestParam("ids") List<Long> ids){
        log.info("根据id批量查询用户");
        List<User> users = iUserService.listByIds(ids);

        return BeanUtil.copyToList(users, UserVO.class);
    }

    @PutMapping("/{id}/deduction/{money}")
    @ApiOperation("根据id和金额删减余额")
    public void deductBalance(@PathVariable Long id, @PathVariable Integer money){
        log.info("根据id和金额删减余额,{},{}",id, money);

        iUserService.deductBalance(id, money);
    }
}
