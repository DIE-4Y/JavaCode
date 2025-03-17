package edu.nenu.tliaswebserver.service.impl;

import edu.nenu.tliaswebserver.aop.MyLog;
import edu.nenu.tliaswebserver.mapper.DeptMapper;
import edu.nenu.tliaswebserver.pojo.Dept;
import edu.nenu.tliaswebserver.pojo.DeptLog;
import edu.nenu.tliaswebserver.service.DeptLogService;
import edu.nenu.tliaswebserver.service.DeptService;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImp implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptLogService deptLogService;

    //查询所有部门
    @MyLog
    @Override
    public List<Dept> deptList() {
        return deptMapper.getDept();
    }


    /**
     * 事务管理删除部门同时删除该部门下的员工
     * @Transactional自动共开启事物 -成功：提交事务 -失败：回滚事务
     * rollbackFor指定异常类型 否则只有RuntimeException才会回滚
     */
    @MyLog
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        try {
            // 根据id删除部门
            deptMapper.deleteById(id);
            // 删除部门对应额员工
            deptMapper.deleteEmpBydeptID(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setDescription("删除id=" + id + "的部门及其下边的员工");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept selct(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
