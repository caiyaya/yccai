package com.server.web.service;

import com.server.web.entity.dto.CourseBase;

import java.util.List;

public interface CourseBaseService {

    List<CourseBase> selectCourseList(CourseBase request);
}
