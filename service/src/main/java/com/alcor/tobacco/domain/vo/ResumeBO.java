package com.alcor.tobacco.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @author guchun
 * @description TODO
 * @date 2022/6/20 23:58
 */
@Data
public class ResumeBO {

    Resume resume;

    List<ResumeContentVO> contents;
}
