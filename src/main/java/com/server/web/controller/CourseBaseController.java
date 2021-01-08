package com.server.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.server.common.util.FastDFSClient;
import com.server.web.common.ResultMap;
import com.server.web.entity.dto.CourseBase;
import com.server.web.entity.dto.FileSystem;
import com.server.web.entity.vo.FastDfsVO;
import com.server.web.mapper.CourseBaseMapper;
import com.server.web.mapper.FileSystemRepository;
import com.server.web.service.CourseBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * mybatis-plus
 */
@Api(tags = "课程库")
@RestController
@RequestMapping("/mp")
public class CourseBaseController {

    @Autowired
    private CourseBaseService courseBaseService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    FileSystemRepository fileSystemRepository;

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Value("${fdfs.httpurl}")
    private String fastDFSHttpurl;

    @ApiOperation("新增")
    @PostMapping("/insert")
    public ResultMap insert(@Valid @RequestBody @ApiParam(name = "data", value = "实体类", required = true) CourseBase request) {// @ApiParam(name = "data", value = "实体类", required = true)
        int i = courseBaseMapper.insert(request);
        return ResultMap.success(i);
    }

    @ApiOperation("通过id查询")
    @PostMapping("/selectById")
    public ResultMap selectById(@Valid @RequestBody CourseBase request) {
        CourseBase courseBase = courseBaseMapper.selectById(request);
        return ResultMap.success(courseBase);
    }

    @ApiOperation("查询列表接口")
    @PostMapping("/course-list")
    public ResultMap selectCourseList(@Valid @RequestBody CourseBase request) {
        QueryWrapper<CourseBase> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .and(name -> name.eq(CourseBase::getName, request.getName()));
//                .and(users -> users.eq(CourseBase::getUsers, request.getUsers()))
//                .and(mt -> mt.like(CourseBase::getMt, request.getMt()));
//                .or()
//                .and(grade -> grade.like(CourseBase::getGrade, request.getGrade()));
        List<CourseBase> courseBase = courseBaseMapper.selectList(queryWrapper);
        return ResultMap.success(courseBase);
    }

    @ApiOperation("通过id修改接口")
    @PostMapping("/updateById")
    public ResultMap updateById(@Valid @RequestBody CourseBase request) {
        int i = courseBaseMapper.updateById(request);
        return ResultMap.success(i);
    }

    @ApiOperation("通过id删除")
    @PostMapping("/deleteById")
    public ResultMap deleteById(@Valid @RequestBody String id) {
        int i = courseBaseMapper.deleteById(id);
        return ResultMap.success(i);
    }



    /**
     * fastdfs,mongodb
     */
    @ApiOperation("文件上传接口")
    @PostMapping("/upload")
    public ResultMap uploadFile(MultipartFile file) throws IOException {
        FileSystem fastDFSFile = new FileSystem();
        //获取文件的完整名称
        String originalFilename = file.getOriginalFilename();
        String[] fileInfo = originalFilename.split(".");
        //获取文件的扩展名称  abc.jpg   jpg
        fastDFSFile.setFileName(fileInfo[0]);
//        fastDFSFile.setContentType(file.getContentType());
        String path = fastDFSClient.uploadFile(file);
        fileSystemRepository.save(fastDFSFile);
        FastDfsVO vo = new FastDfsVO(path, fastDFSHttpurl);
        return ResultMap.success(vo);
    }

    @ApiOperation("文件删除接口")
    @PostMapping("/delete")
    public ResultMap deleteFile(@RequestBody String url) throws IOException {
        fastDFSClient.deleteFile(url);
        return ResultMap.success();
    }
}
