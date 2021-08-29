package com.longdi.eduservice.controller;


import com.longdi.commonutils.R;
import com.longdi.eduservice.client.VodClient;
import com.longdi.eduservice.entity.EduVideo;
import com.longdi.eduservice.service.EduVideoService;
import com.longdi.servicebase.exceptionhandler.LongdiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-15
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
     @Autowired
    private EduVideoService videoService;

     @Autowired
     private VodClient vodClient;
     //添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.ok();
    }
    //删除
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){
       EduVideo eduVideo=  videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();

        if(!StringUtils.isEmpty(videoSourceId)){

         R result =vodClient.removeAlyVideo(videoSourceId);
        if(result.getCode()==20001){
                throw new LongdiException(20001,"删除视频失败，熔断器");

        }
        }

        videoService.removeById(id);
        return R.ok();
    }
    //修改

}

