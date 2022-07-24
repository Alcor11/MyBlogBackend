package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.DocInfo;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author guchun
* @description 针对表【doc_info】的数据库操作Service
* @createDate 2022-07-09 00:45:57
*/
public interface DocInfoService extends IService<DocInfo> {

    /**
     * 按页查询文章列表
     * @param query 查询对象
     * @return 列表
     */
    List<DocInfo> queryList(DocInfoQuery query);


}
