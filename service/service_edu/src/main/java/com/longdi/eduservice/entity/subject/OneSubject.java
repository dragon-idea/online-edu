package com.longdi.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/14 22:11
 */
//一级分类
    @Data
public class OneSubject {
    private String id;
    private String title;
    //一个一级分类有多个二级分类
    private List<TwoSubject> children=new ArrayList<>();

    }
