package com.alcor.tobacco.domain.vo.comment;

import lombok.Data;

import java.util.List;

/**
 * @author guchun
 * @description 文章相关属性
 * @date 2022/7/9 00:50
 */
@Data
public class Meta {

    // TODO
    /**
     * 访问数
     */
    private Long views;

    /**
     * 评论数
     */
    private List<String> comments;

    /**
     * 点赞数
     */
    private Long likes;
}
