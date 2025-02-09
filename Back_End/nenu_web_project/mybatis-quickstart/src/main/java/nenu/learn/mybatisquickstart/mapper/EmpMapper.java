package nenu.learn.mybatisquickstart.mapper;

import lombok.Data;
import nenu.learn.mybatisquickstart.pojo.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {

    // #{}用于占位 调用该方法后会返回一个删除的数量
    @Delete("delete from emp where id = #{id}")
    public void empDelete(Integer id);

    // 传入的#{}是对象的属性名
    // 生成的主键赋值给id且字符串需要使用双引号 获取自增长id
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void empInsert(Emp emp);


    @Update("update emp set username = #{username}, name = #{name}, gender=#{gender}, image=#{image}, job=#{job}, dept_id = #{deptId}, update_time = #{updateTime} where id=#{id}")
    public void empUpdate(Emp emp);
}
