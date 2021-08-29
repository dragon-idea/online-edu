package com.longdi.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/17 12:11
 */
@Data
public class ChapterVo {
    private String id;
    private String title;
    //表示小节
    private List<VideoVo> children=new ArrayList<>();

}
