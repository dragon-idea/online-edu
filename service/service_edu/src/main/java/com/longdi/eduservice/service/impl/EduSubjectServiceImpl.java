package com.longdi.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.longdi.eduservice.entity.EduSubject;
import com.longdi.eduservice.entity.exccel.SubjectData;
import com.longdi.eduservice.entity.subject.OneSubject;
import com.longdi.eduservice.entity.subject.TwoSubject;
import com.longdi.eduservice.listener.SubjectExcelListener;
import com.longdi.eduservice.mapper.EduSubjectMapper;
import com.longdi.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-08-14
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    //添加课程分类
    @Override
    public void saveSubject(MultipartFile file,EduSubjectService subjectService) {
        try{
            //文件输入流
            InputStream in=file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in,SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();

        }

    }
    //课程分类列表(树形)
    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //1 查询所有一级分类
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id", 0);
//        queryWrapper.orderByAsc("sort", "id");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);
        //2 查询所有二级分类
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id", 0);
    //    WrapperTwo.orderByAsc("sort", "id");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);

        //创建list集合，用于存储最终封装数据
        List<OneSubject> finalSubjectList=new ArrayList<>();
        //3 封装一级分类
        for(int i=0;i<oneSubjectList.size();i++){
            EduSubject eduSubject=oneSubjectList.get(i);
            //把eduSubject里面值获取出来，方法OneSubject对象里面
            //多个OneSubject放到finalSubjectList里面
            OneSubject oneSubject=new OneSubject();
  //          oneSubject.setId(eduSubject.getId());
//          oneSubject.setTitle(eduSubject.getTitle());
          BeanUtils.copyProperties(eduSubject,oneSubject);

            finalSubjectList.add(oneSubject);

            //在一级分类循环遍历所有查询的二级分类
            //创建list集合封装的每一个一级分类的二级分类
            List<TwoSubject> twoFinalSubjectList=new ArrayList<>();
            //遍历二级分类list集合
            for (int m = 0; m < twoSubjectList.size(); m++) {
                //获取每个二级分类
                EduSubject tSubject=twoSubjectList.get(m);
                //判断二级分类parentid和一级分类id是否一样
                if(tSubject.getParentId().equals(eduSubject.getId())){
                    TwoSubject twoSubject=new TwoSubject();
                    BeanUtils.copyProperties(tSubject,twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            //把一级分类下面所有的二级分类放到一级分类里面
            oneSubject.setChildren(twoFinalSubjectList);
        }


        return finalSubjectList;
    }
}
