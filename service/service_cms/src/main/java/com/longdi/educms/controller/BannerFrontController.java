package com.longdi.educms.controller;


import com.longdi.commonutils.R;
import com.longdi.educms.entity.CrmBanner;
import com.longdi.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-20
 */
@RestController
@RequestMapping("/educms/bannerfront")
@CrossOrigin
public class BannerFrontController {

    @Autowired
    private CrmBannerService bannerService;

    //查询所有的banner
    @GetMapping("getAllBanner")
    public R getAllBanner(){
        List<CrmBanner> list=bannerService.selectAllBanner();
        return R.ok().data("list",list);
    }

}

