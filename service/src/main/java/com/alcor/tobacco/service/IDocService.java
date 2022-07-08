package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.query.ArticleQuery;
import com.alcor.tobacco.domain.query.BaseQuery;
import com.alcor.tobacco.domain.vo.ArticlesInfoVO;

import java.util.List;

/**
 * @author guchun
 * @description 文档服务接口
 * @date 2022/7/9 00:59
 */
public interface IDocService {

    List<ArticlesInfoVO> getArticleInfo(ArticleQuery query);

    int addNewArticle();
}
