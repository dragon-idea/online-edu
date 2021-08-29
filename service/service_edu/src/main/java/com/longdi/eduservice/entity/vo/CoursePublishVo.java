package com.longdi.eduservice.entity.vo;

import lombok.Data;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/18 12:59
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}

