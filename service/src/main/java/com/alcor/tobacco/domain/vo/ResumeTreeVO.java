package com.alcor.tobacco.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @author guchun
 * @description 返回给前端的投递tree
 * @date 2022/6/20 23:57
 */
@Data
public class ResumeTreeVO {

    List<ResumeBO> resumeTree;
}
