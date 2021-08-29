package com.longdi.msmservice.service;

import java.util.Map;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/21 16:46
 */
public interface MsmService {
    boolean send(Map<String, Object> param, String phone);
}
