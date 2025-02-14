package nenu.learn.mybatisquickstart.mapper;


import nenu.learn.mybatisquickstart.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    // #{}用于占位 调用该方法后会返回一个删除的数量
    @Delete("delete from emp where id = #{id}")
    public void empDelete(Integer id);

    // 传入的#{}是对象的属性名
    // 生成的主键赋值给id且字符串需要使用双引号 获取自增长id
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void empInsert(Emp emp);


//    @Update("update emp set username = #{username}, name = #{name}, gender=#{gender}, image=#{image}, job=#{job}, dept_id = #{deptId}, update_time = #{updateTime} where id=#{id}")
    public void empUpdate(Emp emp);

    // id查询操作 类的属性名和表的字段名不一致 就不会自动封装该字段
    // 可指定别名 或用Results注解 或在proper里添加驼峰命名映射
    @Select("select * from emp where id=#{id}")
    public Emp empSelect(Integer id);

    // select 语句换行的时候 要在上一行末尾加上 “ ” 空格 表示一个独立词语

    // 模糊查询 返回列表
    //@Select("select * from emp where name like concat('%',#{name},'%') and " +
    //"gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
    //可能使用start.spring.io创建的项目不需要加@Param注解
    //public List<Emp> empList(String name, short gender, LocalDate begin, LocalDate end);
    //public List<Emp> empList(@Param("name") String name, @Param("gender") short gender, @Param("begin")LocalDate begin, @Param("end")LocalDate end);

    /*
        用xml进行查询 需要在resources里创建对应相同类型的路径 和文件名
        1.xml映射文件名称与Mapper接口文件一致 xml和映射文件在同包下（相同路径）
        2.xml的namespace与接口文件的引用路径一致
        3.xml映射文件id与Mapper接口的方法名一致 且保证返回类型一致
     */


    public List<Emp> empList(@Param("name") String name, @Param("gender") Short gender, @Param("begin")LocalDate begin, @Param("end")LocalDate end);

    //批量删除员工
    public void empDeleteById(@Param("ids") List<Integer> ids);
}