package com.longdi.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/13 15:55
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
