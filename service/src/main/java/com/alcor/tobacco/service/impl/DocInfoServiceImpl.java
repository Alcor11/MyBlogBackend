package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.domain.entity.DocCont;
import com.alcor.tobacco.domain.entity.DocInfo;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import com.alcor.tobacco.domain.vo.DocInfoVO;
import com.alcor.tobacco.domain.vo.NewDocVO;
import com.alcor.tobacco.mapper.DocContMapper;
import com.alcor.tobacco.mapper.DocInfoMapper;
import com.alcor.tobacco.mapstruct.DocContMap;
import com.alcor.tobacco.mapstruct.DocInfoMap;
import com.alcor.tobacco.service.DocInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
* @author guchun
* @description 针对表【doc_info】的数据库操作Service实现
* @createDate 2022-07-09 00:45:57
*/
@Service
@Slf4j
public class DocInfoServiceImpl extends ServiceImpl<DocInfoMapper, DocInfo>
    implements DocInfoService {

    @Resource
    DocInfoMap docInfoMap;

    @Resource
    DocContMap docContMap;

    @Resource
    DocContMapper docContMapper;

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

    @Override
    @Transactional
    public int addNewDocInfoAndCont(NewDocVO newDocVO) {
        DocInfo docInfo = docInfoMap.ndVoToDo(newDocVO);
        DocCont docCont = docContMap.voToDo(newDocVO);
        UUID docGuidUUID = UUID.randomUUID();
        String docGuid = docGuidUUID + docInfo.getTitle();
        docInfo.setDocGuid(docGuid);
        docCont.setDocGuid(docGuid);
        boolean save = this.save(docInfo);
        int insert = docContMapper.insert(docCont);
        if (save && insert == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional
    public int deleteDocByDocGuid(String docGuid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("doc_guid", docGuid);
        boolean remove = this.remove(wrapper);
        int delete = docContMapper.delete(wrapper);
        if (remove && delete == 1) {
            return 1;
        }
        return 0;
    }
}




