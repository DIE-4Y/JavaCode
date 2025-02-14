package nenu.learn.mybatisquickstart;

import nenu.learn.mybatisquickstart.mapper.EmpMapper;
import nenu.learn.mybatisquickstart.mapper.UserMapper;
import nenu.learn.mybatisquickstart.pojo.Emp;
import nenu.learn.mybatisquickstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisQuickstartApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userListTest() {
        List<User> users = userMapper.userList();
        users.stream().forEach(user -> {
            System.out.println(user);
        });

    }

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void empDeleteTest() {
        empMapper.empDelete(17);
    }

    /*
        插入员工信息

     */
    @Test
    public void empInsertTest() {
        Emp emp = new Emp();
        emp.setName("Tom2");
        emp.setUsername("Tom2");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(1, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.empInsert(emp);

        // 加了注解才能获取自增长的id
        System.out.println(emp.getId());
    }

    @Test
    public void empUpdateTest() {
        Emp emp = new Emp();
        emp.setId(19);
        emp.setName("汤姆0");
//        emp.setUsername("Tom1");
//        emp.setImage("1.jpg");
//        emp.setGender((short) 1);
//        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(1, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.empUpdate(emp);
        // 加了注解才能获取自增长的id

    }

    @Test
    public void empSelectTest() {
        Emp emp = empMapper.empSelect(3);
        System.out.println(emp);
    }

    @Test
    public void empListTest() {
//        List<Emp> empList =  empMapper.empList("张", (short)1, LocalDate.of(2010, 1, 1), LocalDate.of(2030, 1, 1));
//        List<Emp> empList =  empMapper.empList("张", null, null, null);
//        List<Emp> empList = empMapper.empList(null, (short)1, null, null);
        List<Emp> empList =  empMapper.empList(null, null, null, null);
        System.out.println(empList);
    }


    @Test
    public void empDeleteTest2(){
        List ids = Arrays.asList(19, 18);
        empMapper.empDeleteById(ids);
    }
}
