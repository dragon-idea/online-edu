package com.longdi.servicebase.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/7/28 15:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LongdiException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;//异常信息
}
