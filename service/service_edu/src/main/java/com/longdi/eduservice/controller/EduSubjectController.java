package com.longdi.eduservice.controller;


import com.longdi.commonutils.R;
import com.longdi.eduservice.entity.EduSubject;
import com.longdi.eduservice.entity.subject.OneSubject;
import com.longdi.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-14
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService subjectService;

    //添加课程分类
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        //上传过来excel文件
        subjectService.saveSubject(file,subjectService);
        return R.ok();
    }
    //课程分类列表
    @GetMapping("getAllSubject")
    public R getAllSubject(){
        //list集合泛型是一级分类
      List<OneSubject>  list=subjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }

}

