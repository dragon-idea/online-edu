package com.longdi.demo.exccel;


import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/13 23:08
 */
public class TestEasyExcel {
    public static void main(String[] args) {

    //实现excel写操作
    //1.设置写入文件夹地址和excel文件名称
//    String filename="D:\\write.xlsx";

    //2.调用easyexccel里面的方法实现写操作
 //   EasyExcel.write(filename,DemoData.class).sheet("学生列表").doWrite(getData());
        //实现excel读操作
        String filename="D:\\write.xlsx";
        EasyExcel.read(filename,DemoData.class,new ExcelListener()).sheet().doRead();
    }
    //创建方法返回list集合
    private static List<DemoData> getData(){
        List<DemoData> list =new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            DemoData data =new DemoData();
            data.setSno(i);
            data.setSname("lucy"+i);
            list.add(data);
        }
        return list;
    }
}
