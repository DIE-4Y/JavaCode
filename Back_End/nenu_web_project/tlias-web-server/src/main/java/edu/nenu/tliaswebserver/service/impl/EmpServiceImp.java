package edu.nenu.tliaswebserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.nenu.tliaswebserver.mapper.EmpMapper;
import edu.nenu.tliaswebserver.pojo.Emp;
import edu.nenu.tliaswebserver.pojo.PageBean;
import edu.nenu.tliaswebserver.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 采用pagehelper分页
     * 1.设置分页参数
     * 2.执行查询
     * 3.返回结果
     */
    @Override
    public PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.pageList(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    /**
     * 传统方法 不使用pagehelper分页
     */
    /*public PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageBean pageBean = new PageBean();
        pageBean.setTotal(empMapper.count());
        pageBean.setRows(empMapper.pageList(name, gender, begin, end));
        return pageBean;
    }*/
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp getEmp(Integer id) {
        return empMapper.getEmp(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }
}
