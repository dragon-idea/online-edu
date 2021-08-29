package com.longdi.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.longdi.oss.service.OssService;
import com.longdi.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/13 15:56
 */
@Service
public class OssServiceImpl implements OssService {
    //上传头像到oss
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        //获取阿里云存储相关常量
        String endPoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;

        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        String uploadUrl = null;
        try {
//判断oss实例是否存在：如果不存在则创建，如果存在则获取
            OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
//            if (!ossClient.doesBucketExist(bucketName)) {
////创建bucket
//                ossClient.createBucket(bucketName);
////设置oss实例的访问权限：公共读
//                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
//            }
////获取上传文件流
            InputStream inputStream = file.getInputStream();

//文件名：uuid.扩展名
             String fileName = file.getOriginalFilename();
             String uuid=UUID.randomUUID().toString().replace("-","");
             fileName=uuid+fileName;
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //构建日期路径：avatar/2019/02/26/文件名

            fileName=datePath+"/"+fileName;
//            String fileName = UUID.randomUUID().toString();
//            String fileType = original.substring(original.lastIndexOf("."));
//            String newName = fileName + fileType;
//            String fileUrl = fileHost + "/" + filePath + "/" + newName;
//文件上传至阿里云
            ossClient.putObject(bucketName, fileName, inputStream);
// 关闭OSSClient。
            ossClient.shutdown();
//获取url地址
         String  url = "http://" + bucketName + "." + endPoint + "/" + fileName;
         return url;
        } catch (IOException e) {

        }
        return null;
    }
}