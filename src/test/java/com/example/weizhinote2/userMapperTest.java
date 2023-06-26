package com.example.weizhinote2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.weizhinote2.Mapper.usrMapper;
@SpringBootTest
public class userMapperTest {

    private usrMapper usrMapper;

    @Autowired
    public userMapperTest(usrMapper usrMapper){
        this.usrMapper=usrMapper;

    }
@Test
    public void test(){
        System.out.println(("----- selectAll method test ------"));
        usrMapper.selectList(null).forEach(System.out::println);
    }

}
