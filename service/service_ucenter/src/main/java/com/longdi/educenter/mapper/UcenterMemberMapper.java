package com.longdi.educenter.mapper;

import com.longdi.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-08-21
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {


    Integer countRegisterDat(String day);
}
