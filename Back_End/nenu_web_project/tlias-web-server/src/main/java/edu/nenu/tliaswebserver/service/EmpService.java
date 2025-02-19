package edu.nenu.tliaswebserver.service;

import edu.nenu.tliaswebserver.pojo.Emp;
import edu.nenu.tliaswebserver.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getEmp(Integer id);

    void updateEmp(Emp emp);
}
