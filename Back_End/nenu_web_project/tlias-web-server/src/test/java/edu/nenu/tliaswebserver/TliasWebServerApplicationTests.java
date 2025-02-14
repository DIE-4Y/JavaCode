package edu.nenu.tliaswebserver;

import edu.nenu.tliaswebserver.controller.DeptController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TliasWebServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DeptController deptController;
}
