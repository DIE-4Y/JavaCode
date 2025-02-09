package nenu.learn.mybatisquickstart;

import nenu.learn.mybatisquickstart.mapper.UserMapper;
import nenu.learn.mybatisquickstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisQuickstartApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;
    @Test
    public void userListTest(){
        List<User> users = userMapper.userList();
        users.stream().forEach(user -> {
            System.out.println(user);
        });

    }

}
