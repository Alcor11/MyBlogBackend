package com.alcor.tobacco.domain.query;

import lombok.Data;

import java.util.List;

/**
 * @author guchun
 * @description TODO
 * @date 2022/7/9 00:55
 */
@Data
public class ArticleQuery extends BaseQuery {

    private List<String> keywords;

    private boolean likes;

    /**
     * 文章发布状态 => 0 草稿，1 已发布,'' 代表所有文章
     */
    private int state;

    private int tag_id;

    private int category_id;

    private int pageNum;

    private int pageSize;

}
