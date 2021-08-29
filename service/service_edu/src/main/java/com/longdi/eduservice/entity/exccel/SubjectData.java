package com.longdi.eduservice.entity.exccel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/14 11:40
 */
@Data
public class SubjectData {
    //设置列对应的属性
    @ExcelProperty(index = 0)
    private String onSubjectName;
    //设置列对应的属性
    @ExcelProperty(index = 1)
    private String twoSubjectname;
}
