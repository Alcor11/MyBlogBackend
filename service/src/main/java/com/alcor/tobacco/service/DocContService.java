package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.DocCont;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author guchun
* @description 针对表【doc_cont】的数据库操作Service
* @createDate 2022-07-09 01:01:50
*/
public interface DocContService extends IService<DocCont> {

    /**
     * 根据doc guid 获取详情
     * @param docGuid 文档唯一id
     * @return 文档详情
     */
    DocCont getDocContByGuid(String docGuid);

}
