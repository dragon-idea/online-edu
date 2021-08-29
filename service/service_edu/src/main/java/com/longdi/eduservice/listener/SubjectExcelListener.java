package com.longdi.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.longdi.eduservice.entity.EduSubject;
import com.longdi.eduservice.entity.exccel.SubjectData;
import com.longdi.eduservice.service.EduSubjectService;
import com.longdi.servicebase.exceptionhandler.LongdiException;
import jdk.internal.org.objectweb.asm.commons.AnalyzerAdapter;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/14 11:48
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    public EduSubjectService subjectService;
    public SubjectExcelListener(){};
    public SubjectExcelListener(EduSubjectService subjectService){
        this.subjectService=subjectService;
    }
    //一行一行读取
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext context) {

        if (subjectData==null){
            throw new LongdiException(20001,"文件数据为空");
        }
            //一行行读取
        EduSubject existOneSubject=this.existOneSubject(subjectService,subjectData.getOnSubjectName());
        if(existOneSubject==null){//没有相同一级分类，进行添加
            existOneSubject=new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOnSubjectName());//一级分类名称
            subjectService.save(existOneSubject);
        }
        //获取一级分类的id值
        String pid=existOneSubject.getId();
        //添加二级分类

        EduSubject existTwoSubject=this.existTwoSubject(subjectService,subjectData.getTwoSubjectname(),pid);
        if(existTwoSubject==null){//没有相同一级分类，进行添加
            existTwoSubject=new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectname());//二级分类名称
            subjectService.save(existTwoSubject);
        }
    }
    //判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService subjectService,String name){
        QueryWrapper<EduSubject> wrapper=new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject onesubject=subjectService.getOne(wrapper);
        return onesubject;
    }
    //判断二级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService subjectService,String name,String pid){
        QueryWrapper<EduSubject> wrapper=new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject twosubject=subjectService.getOne(wrapper);
        return twosubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
