package com.server.web.entity.dto;

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

    /**
     * id
     */
    private String id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 适用人群
     */
    private String users;

    /**
     * 课程大分类
     */
    private String mt;

    /**
     * 课程等级
     */
    private String grade;

    /**
     * 学习模式
     */
    private String studymodel;

    /**
     * 授课模式
     */
    private String teachmode;

    /**
     * 课程介绍
     */
    private String description;

    /**
     * 课程小分类
     */
    private String st;

    /**
     * 课程状态
     */
    private String status;

    /**
     * 教育机构
     */
    private String companyId;

    /**
     * 创建用户
     */
    private String userId;


}
