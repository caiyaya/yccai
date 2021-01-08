package com.server.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.server.web.entity.dto.CourseBase;
import com.server.web.mapper.CourseBaseMapper;
import com.server.web.service.CourseBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseBaseServiceImpl implements CourseBaseService {

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Override
    public List<CourseBase> selectCourseList(CourseBase request) {
        QueryWrapper<CourseBase> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .and(name -> name.eq(CourseBase::getName, request.getName()))
                .and(users -> users.eq(CourseBase::getUsers, request.getUsers()))
                .and(mt -> mt.like(CourseBase::getMt, request.getMt()));
//                .or()
//                .and(grade -> grade.like(CourseBase::getGrade, request.getGrade()));
        List<CourseBase> courseBase = courseBaseMapper.selectList(queryWrapper);
        return courseBase;
    }


}
