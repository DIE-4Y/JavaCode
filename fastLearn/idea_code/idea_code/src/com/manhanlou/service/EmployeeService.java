package com.manhanlou.service;

import com.manhanlou.dao.EmployeeDAO;
import com.manhanlou.domain.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDao = new EmployeeDAO();

    //根据密码和id获取雇员对象
    public Employee getEmployeeByIdAndPwd(String empId, String password) {
        return employeeDao.querySingle("select * from employee where empId=? and password=MD5(?)", Employee.class, empId, password);
    }


}
