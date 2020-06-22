package com.server.web.controller;

import com.server.common.util.FastDFSClient;
import com.server.web.common.ResultMap;
import com.server.web.entity.dto.CourseBase;
import com.server.web.entity.dto.FileSystem;
import com.server.web.entity.vo.FastDfsVO;
import com.server.web.mapper.FileSystemRepository;
import com.server.web.service.CourseBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @Value("${fdfs.httpurl}")
    private String fastDFSHttpurl;

    @ApiOperation("查询列表接口")
    @PostMapping("/course-list")
    public ResultMap selectCourseList(@Valid @RequestBody CourseBase request) {
        List<CourseBase> courseBaseDTO = courseBaseService.selectCourseList(request);
        return ResultMap.success(courseBaseDTO);
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
