package com.alcor.tobacco.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author guchun
 * @description 简历单条
 * @date 2022/6/9 20:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    private Long id;

    /**
     * 公司名
     */
    private String comName;

    /**
     * 投递时间
     */
    private Date resuDate;

    /**
     * 投递方式
     */
    private String submitFunc;

    /**
     * 网址
     */
    private String netData;

}
