package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.domain.DocInfo;
import com.alcor.tobacco.domain.query.ArticleQuery;
import com.alcor.tobacco.domain.vo.ArticlesInfoVO;
import com.alcor.tobacco.service.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author guchun
 * @description 文档相关内容实现
 * @date 2022/7/9 01:00
 */
public class DocServiceImpl implements IDocService {

    @Autowired
    DocInfoService infoService;

    @Autowired
    DocMetaService metaService;

    @Autowired
    DocTagService tagService;

    @Autowired
    DocContService contService;

    @Override
    public List<ArticlesInfoVO> getArticleInfo(ArticleQuery query) {

        // TODO 实现查询文档列表
        // 从doc_info中查询出article list

        return null;
    }

    @Override
    @Transactional
    public int addNewArticle() {
        return 0;
    }

}
