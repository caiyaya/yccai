package com.server.web.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author huanghua
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("课程名称")
    private String name;

    @ApiModelProperty("适用人群")
    private String users;

    @ApiModelProperty("课程大分类")
    private String mt;

    @ApiModelProperty("课程等级")
    private String grade;

    @ApiModelProperty("学习模式")
    private String studymodel;

    @ApiModelProperty("授课模式")
    private String teachmode;

    @ApiModelProperty("课程介绍")
    private String description;

    @ApiModelProperty("课程小分类")
    private String st;

    @ApiModelProperty("课程小分类")
    private String status;

    @ApiModelProperty("教育机构")
    private String companyId;

    @ApiModelProperty("创建用户")
    private String userId;


}
