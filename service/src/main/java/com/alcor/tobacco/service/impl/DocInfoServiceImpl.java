package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.domain.DocInfo;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import com.alcor.tobacco.domain.vo.DocInfoVO;
import com.alcor.tobacco.mapper.DocInfoMapper;
import com.alcor.tobacco.mapstruct.DocInfoMap;
import com.alcor.tobacco.service.DocInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* @author guchun
* @description 针对表【doc_info】的数据库操作Service实现
* @createDate 2022-07-09 00:45:57
*/
@Service
public class DocInfoServiceImpl extends ServiceImpl<DocInfoMapper, DocInfo>
    implements DocInfoService {

    @Resource
    DocInfoMap docInfoMap;

    @Override
    public List<DocInfo> queryList(DocInfoQuery query) {
        QueryWrapper queryWrapper = query.buildQuery();
        Page<DocInfo> page = query.buildPage();
        Page<DocInfo> infoPage = this.baseMapper.selectPage(page, queryWrapper);

        return infoPage.getRecords();
    }

    @Override
    public List<DocInfoVO> queryDocVoList(DocInfoQuery query) {
        List<DocInfoVO> ret = new ArrayList<>();
        List<DocInfo> list = this.queryList(query);
        Iterator<DocInfo> iterator = list.iterator();
        while (iterator.hasNext()) {
            DocInfo docinfo = iterator.next();
            ret.add(docInfoMap.doToVo(docinfo));
        }
        return ret;
    }
}




