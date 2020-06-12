package com.server.web.controller;

import com.server.web.common.ResultMap;
import com.server.web.entity.dto.CourseBase;
import com.server.web.service.CourseBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * mybatis-plus
 */
@Api(tags = "课程库")
@RestController
@RequestMapping("/cc")
public class CourseBaseController {

    @Autowired
    private CourseBaseService courseBaseService;


    @ApiOperation("查询列表接口")
    @PostMapping("/container-list")
    public ResultMap selectCourseList(@Valid @RequestBody CourseBase request) {
        List<CourseBase> courseBaseDTO = courseBaseService.selectCourseList(request);
        return ResultMap.success(courseBaseDTO);
    }
}
