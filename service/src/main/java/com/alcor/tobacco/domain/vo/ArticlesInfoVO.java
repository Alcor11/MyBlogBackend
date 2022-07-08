package com.alcor.tobacco.domain.vo;

import com.alcor.tobacco.domain.vo.comment.Meta;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @author guchun
 * @description 文章列表中的每条文章的info
 * @date 2022/7/9 00:48
 */

@Data
public class ArticlesInfoVO {

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 说明
     */
    private String desc;

    /**
     * 点赞、访问、评论等参数
     */
    private List<Meta> meta;

    private LocalDate create_time;
}
