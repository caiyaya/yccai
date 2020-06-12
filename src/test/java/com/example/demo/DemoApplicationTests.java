package com.example.demo;

import com.server.web.mapper.CourseBaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest
class DemoApplicationTests {

    @Resource
    private CourseBaseMapper mapper;

    @Test
    void contextLoads() {
    }

}
