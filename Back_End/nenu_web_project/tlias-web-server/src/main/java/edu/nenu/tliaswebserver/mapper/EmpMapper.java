package edu.nenu.tliaswebserver.mapper;

import edu.nenu.tliaswebserver.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp")
    Long count();


    /**
     * 使用pagehelper后不需要手动进行分页操作
     */
    /*@Select("select * from emp where name like concat('%', #{name}, '%')" +
            " and gender = #{gender} and entrydate between #{begin}" +
            " and #{end} order by update_time desc")*/
    List<Emp> pageList(@Param("name") String name, @Param("gender") Short gender,
                       @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    /**
     * 批量删除员工
     */
    void delete(@Param("ids") List<Integer> ids);

    void add(Emp emp);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    Emp getEmp(Integer id);

    void updateEmp(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp findByIdAndPassword(Emp emp);


    //public List<Emp> pageList(String name, Short gender,LocalDate begin,LocalDate end);
    /**
     * 手动分页
     * 多参数传递需要用Param注解制定参数名称
     * @return
     */
    //@Select("select * from  emp limit #{start}, #{pageSize}")
    //List<Emp> pageList(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

}
