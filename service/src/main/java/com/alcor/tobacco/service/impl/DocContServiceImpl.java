package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.domain.DocCont;
import com.alcor.tobacco.mapper.DocContMapper;
import com.alcor.tobacco.service.DocContService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author guchun
* @description 针对表【doc_cont】的数据库操作Service实现
* @createDate 2022-07-09 01:01:50
*/
@Service
public class DocContServiceImpl extends ServiceImpl<DocContMapper, DocCont>
    implements DocContService {

    @Override
    public DocCont getDocContByGuid(String docGuid) {
        // TODO 拒绝策略，防止乱查询
        QueryWrapper<DocCont> wrapper = new QueryWrapper<>();
        wrapper.eq("doc_guid", docGuid);
        return this.getOne(wrapper);
    }
}




