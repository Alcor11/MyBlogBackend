package com.alcor.tobacco.domain.query;

import com.alcor.tobacco.aspectlj.config.MyQuery;
import com.alcor.tobacco.domain.DocInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guchun
 * @description TODO
 * @date 2022/7/11 22:01
 */
@Data
@NoArgsConstructor
public class DocInfoQuery extends BasePageQuery{

    @MyQuery(value = BaseQuery.eq, column = "tag")
    private String tag;

    private List<String> keywords;

    private boolean likes;

    /**
     * 文章发布状态 => 0 草稿，1 已发布,'' 代表所有文章
     */
    private int state;

    private int tag_id;

    private int category_id;

}
