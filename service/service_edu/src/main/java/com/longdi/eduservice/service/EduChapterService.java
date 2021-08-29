package com.longdi.eduservice.service;

import com.longdi.eduservice.entity.chapter.ChapterVo;
import com.longdi.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-08-15
 */
public interface EduChapterService extends IService<EduChapter> {
    //根据课程id查询
    List<ChapterVo> getChapterViedoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);



}
