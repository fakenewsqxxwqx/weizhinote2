package com.example.weizhinote2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Weizhinote2ApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void contextLoads() {
        int result=jdbcTemplate.queryForObject("SELECT 2",Integer.class);
        System.out.println(result);
        Assertions.assertEquals(2,result);
    }
}
