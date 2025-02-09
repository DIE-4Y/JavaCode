package nenu.learn.mybatisquickstart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   //包含 getter setter toString hashcode equals
@NoArgsConstructor      //无参构造
@AllArgsConstructor     //有参构造
public class User {
    private Integer id;
    private String name;
    private short age;
    private short gender;
    private String phone;

}
