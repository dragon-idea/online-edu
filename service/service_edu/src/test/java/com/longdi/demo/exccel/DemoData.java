package com.longdi.demo.exccel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/13 23:02
 */
@Data
public class DemoData {
    @ExcelProperty(value = "学生编号",index=0)
    private Integer sno;
    @ExcelProperty(value = "学生姓名",index=1)
    private String sname;
}
