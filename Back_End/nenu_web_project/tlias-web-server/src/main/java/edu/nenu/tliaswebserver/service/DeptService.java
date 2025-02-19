package edu.nenu.tliaswebserver.service;

import edu.nenu.tliaswebserver.pojo.Dept;
import java.util.List;

public interface DeptService {

    List<Dept> deptList();

    void delete(Integer id);

    void add(Dept dept);

    Object selct(Integer id);

    void update(Dept dept);
}
