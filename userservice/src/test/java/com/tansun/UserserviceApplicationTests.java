package com.tansun;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
class UserserviceApplicationTests {

    @Value("${sp.user-service.users}")
    private String userJson;
    @Test
    void contextLoads() {
        System.out.println("userJson--->"+userJson);
    }

}
