package com.longdi.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/19 11:04
 */
public interface VodService {
    String uploadVideoAly(MultipartFile file);

    void removeMoreAlyVideo(List videoIdList);
}
