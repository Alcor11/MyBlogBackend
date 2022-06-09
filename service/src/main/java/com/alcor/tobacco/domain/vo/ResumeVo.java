package com.alcor.tobacco.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guchun
 * @description 投递VO
 * @date 2022/6/9 20:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeVo {

    List<Resume> resumeList;

}
