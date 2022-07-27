package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.entity.SiteInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author guchun
* @description 针对表【site_info】的数据库操作Service
* @createDate 2022-07-27 23:33:46
*/
public interface SiteInfoService extends IService<SiteInfo> {

    SiteInfo getSiteInfo();

}
