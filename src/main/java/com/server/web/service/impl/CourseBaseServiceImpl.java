package com.server.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.server.common.exception.ExceptionCast;
import com.server.common.model.response.MpResponseCode;
import com.server.common.util.FastDFSClient;
import com.server.web.entity.dto.CourseBase;
import com.server.web.mapper.CourseBaseMapper;
import com.server.web.service.CourseBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
//        queryWrapper.lambda()
//                .and(leftTime -> leftTime.eq(VcsWorkSheet::getLeftTime, request.getLeftTime()))
//                .and(wkSheetStatus -> wkSheetStatus.eq(VcsWorkSheet::getWkSheetStatus, request.getWkSheetStatus()))
//                .and(phone -> phone.like(VcsWorkSheet::getPhone, request.getPhoneOrLeftMsg()))
//                .or()
//                .and(leftMsg -> leftMsg.like(VcsWorkSheet::getLeftMsg, request.getPhoneOrLeftMsg()));
//        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<CourseBase> courseBase = courseBaseMapper.selectList(queryWrapper);
        // 异常处理
//        ExceptionCast.cast(MpResponseCode.FILE_NOT_EXIST);
        return courseBase;
    }

}
