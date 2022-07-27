package com.alcor.tobacco.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName site_info
 */
@TableName(value ="site_info")
@Data
public class SiteInfo implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 座右铭
     */
    private String slogan;

    /**
     * 博客名
     */
    private String name;

    /**
     * 域名
     */
    private String domain;

    /**
     * 注释
     */
    private String notice;

    /**
     * 说明
     */
    private String describ;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}