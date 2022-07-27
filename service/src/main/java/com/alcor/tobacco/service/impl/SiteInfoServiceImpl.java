package com.alcor.tobacco.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alcor.tobacco.domain.entity.SiteInfo;
import com.alcor.tobacco.service.SiteInfoService;
import com.alcor.tobacco.mapper.SiteInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author guchun
* @description 针对表【site_info】的数据库操作Service实现
* @createDate 2022-07-27 23:33:46
*/
@Service
public class SiteInfoServiceImpl extends ServiceImpl<SiteInfoMapper, SiteInfo>
    implements SiteInfoService{

    @Override
    public SiteInfo getSiteInfo() {

        return this.getById(1);
    }
}




