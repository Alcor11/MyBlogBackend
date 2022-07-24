package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.domain.DocInfo;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import com.alcor.tobacco.mapper.DocInfoMapper;
import com.alcor.tobacco.service.DocInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author guchun
* @description 针对表【doc_info】的数据库操作Service实现
* @createDate 2022-07-09 00:45:57
*/
@Service
public class DocInfoServiceImpl extends ServiceImpl<DocInfoMapper, DocInfo>
    implements DocInfoService {



    @Override
    public List<DocInfo> queryList(DocInfoQuery query) {
        QueryWrapper queryWrapper = query.buildQuery();
        Page<DocInfo> page = query.buildPage();
        Page<DocInfo> infoPage = this.baseMapper.selectPage(page, queryWrapper);

        return infoPage.getRecords();
    }
}




