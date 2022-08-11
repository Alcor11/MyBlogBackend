package com.alcor.tobacco.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @author guchun
 * @description 添加新文章的VO
 * @date 2022/8/11 23:11
 */
public class NewDocVO {

    /**
     *
     */
    private String title;

    /**
     * 内容tag
     */
    private String tag;

    /**
     * 内容类型
     */
    @TableField(value = "doc_desc")
    private String docDesc;

    /**
     * 唯一编号
     */
    private String docGuid;

    /**
     * 缩略图
     */
    private String banner;

    /**
     *
     */
    private String docClass;

    /**
     *
     */
    private String content;
}
