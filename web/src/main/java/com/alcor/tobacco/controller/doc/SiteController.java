package com.alcor.tobacco.controller.doc;

import com.alcor.tobacco.domain.entity.SiteInfo;
import com.alcor.tobacco.response.BaseResponse;
import com.alcor.tobacco.service.SiteInfoService;
import com.alcor.tobacco.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guchun
 * @description 页面信息控制器
 * @date 2022/7/27 23:37
 */
@RestController
@RequestMapping("/api")
public class SiteController {

    @Autowired
    SiteInfoService siteService;

    @GetMapping("/site")
    public BaseResponse<SiteInfo> getSiteInfo() {
        SiteInfo siteInfo = siteService.getSiteInfo();
        return ResultUtils.success(siteInfo);
    }
}
