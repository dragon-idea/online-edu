package com.longdi.eduservice.controller;




import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.longdi.commonutils.R;
import com.longdi.eduservice.entity.EduTeacher;
import com.longdi.eduservice.entity.vo.TeacherQuery;
import com.longdi.eduservice.service.EduTeacherService;

import com.longdi.servicebase.exceptionhandler.LongdiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-07-27
 */
@Api(description="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin //解决跨域

public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;
    //查询讲师表所有的数据
    //rest风格
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        //调用service的方法实现所有的操作
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }
    //2.逻辑删除讲师的方法
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)@PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }
    //3.分页查询讲师方法
    //current 当前业
    //limit  每页记录数
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit){

        //创建page对象
        Page<EduTeacher> pageTeacher=new Page<>(current,limit);
        try{int i=10/0;}
        catch(Exception e){
            throw new LongdiException(20001,"执行了自定义异常");
        }
        //调用方法实现分页
        //调用方法的时候，底层封装，把分页所有的数据封装到pageTeacher对象里面
        teacherService.page(pageTeacher,null);
        long total=pageTeacher.getTotal(); //总记录数
        List<EduTeacher> records=pageTeacher.getRecords(); //数据List集合

//        Map map=new HashMap();
//        map.put("total",total);
//        map.put("rows",records);
//        return R.ok().data(map);

        return R.ok().data("total",total).data("rows",records);

    }
    //4.条件查询带分页的方法
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){

        //创建page对象
        Page<EduTeacher> pageTeacher=new Page<>(current,limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper=new QueryWrapper<>();
        //多条件组合查询
        //mybatis学过，动态sql
        //判断条件是否为空，如果不为空拼接条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        //排序
        wrapper.orderByDesc("gmt_create");

        //调用方法实现条件查询分页
        teacherService.page(pageTeacher,wrapper);
        long total=pageTeacher.getTotal();//总记录数
        List<EduTeacher> records=pageTeacher.getRecords(); //数据List集合

        return R.ok().data("total",total).data("rows",records);

    }
    //添加讲师接口的方法
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
    boolean save=teacherService.save(eduTeacher);
    if(save){
        return R.ok();
    }else{
        return R.error();
    }
    }
    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }
    //讲师修改功能
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduteacher){
        boolean flag = teacherService.updateById(eduteacher);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }

}

