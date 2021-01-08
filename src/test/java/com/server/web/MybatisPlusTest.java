package com.server.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.server.web.entity.dto.CourseBase;
import com.server.web.mapper.CourseBaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

    @Resource
    private CourseBaseMapper courseBaseMapper;

    @Test
    public void selectByIdTest() {
        CourseBase courseBase = courseBaseMapper.selectById("297e7c7c62b888f00162b8a7dec20000");
        System.out.println(courseBase);
    }

    @Test
    public void selectTest() {
        QueryWrapper<CourseBase> queryWrapper = new QueryWrapper<>();
        List<CourseBase> courseBase = courseBaseMapper.selectList(queryWrapper);
        System.out.println(courseBase);
    }

}
