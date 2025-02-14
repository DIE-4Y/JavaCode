package edu.nenu.tliaswebserver.service;

import edu.nenu.tliaswebserver.mapper.DeptMapper;
import edu.nenu.tliaswebserver.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    //查询所有部门
    public List<Dept> deptList() {
        return deptMapper.getDept();
    }

    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    public Dept selct(Integer id) {
        return deptMapper.findById(id);
    }

    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
