package com.longdi.eduservice.client;

import com.longdi.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/19 18:39
 */
@Component
public class VodFileDegradeFeignClient implements VodClient{
    @Override
    public R removeAlyVideo(String id) {
        return R.error().message("删除视频出错");
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return R.error().message("删除多个视频出错");
    }
}
