package com.alcor.tobacco.domain.query;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guchun
 * @description TODO
 * @date 2022/7/9 00:55
 */
@Data
@NoArgsConstructor
public class ArticleQuery extends BasePageQuery{

    private List<String> keywords;

    private boolean likes;

    /**
     * 文章发布状态 => 0 草稿，1 已发布,'' 代表所有文章
     */
    private int state;

    private int tag_id;

    private int category_id;


}
