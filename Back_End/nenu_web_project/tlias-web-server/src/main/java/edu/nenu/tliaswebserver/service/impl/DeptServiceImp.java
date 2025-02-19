package edu.nenu.tliaswebserver.service.impl;

import edu.nenu.tliaswebserver.mapper.DeptMapper;
import edu.nenu.tliaswebserver.pojo.Dept;
import edu.nenu.tliaswebserver.service.DeptService;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImp implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    //查询所有部门
    @Override
    public List<Dept> deptList() {
        return deptMapper.getDept();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
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
