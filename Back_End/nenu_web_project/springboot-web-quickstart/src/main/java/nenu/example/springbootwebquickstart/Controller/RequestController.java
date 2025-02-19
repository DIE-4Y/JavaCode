package nenu.example.springbootwebquickstart.Controller;

import nenu.example.springbootwebquickstart.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {

    //springboot 的简单请求方式 GET和POST都可自动识别
    @RequestMapping("/simpleController")
    public String simpleController(String name, Integer age) {
        System.out.println("name: " + name + "age :" + age);
        return "OK";
    }

    /*
        springboot的复杂GET对象请求
        传递的时候用 . 传递对象的属性
     */
    @RequestMapping("/complexController")
    public String complexController(User user) {
        System.out.println(user);
        return "complexController 调用成功";
    }

    /*
        1.springboot 的array请求
        2.springboot 的list请求

        用合适的参数接收就行， list要处理一下 使用@RequestParam指定将类型转为集合list类型
        否则默认转化为array数组类型
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "arrayController 调用成功";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "listController 调用成功";
    }

    /*
        时间参数传递
        需要用注解指定格式
     */
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime localDateTime) {
        System.out.println(localDateTime);
        return "dateParam 调用成功";
    }

    /*
        json参数 一般用对象接收
        需要加注解 指定参数类型
     */
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "dateParam 调用成功";
    }

    /*
        路径参数 可为一个可为多个
     */
    @RequestMapping("/pathParam/{id}")
    public String pathParam1(@PathVariable Integer id) {
        System.out.println("id" + id);
        return "pathParam 调用成功";
    }

    @RequestMapping("/pathParam/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        System.out.println("id: " + id + " name: " + name);
        return "pathParam 调用成功";
    }
}
