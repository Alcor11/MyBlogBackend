package com.alcor.tobacco.domain.vo;

import lombok.Data;

/**
 * @author guchun
 * @description 提交投递进度vo
 * @date 2022/6/13 19:48
 */
@Data
public class ResumeContentVO {

    /**
     * 提交内容说明
     */
    private String resumeContent;

    /**
     * resume_doc中的id
     */
    private Integer resumeId;

    /**
     * 当前进度 0 未投 1 投了无反馈 2 流程中 3 笔试 4 面试 5 拿下 6 寄了
     */
    private Integer resumeStatus;

    /**
     * 面经（支持markdown
     */
    private String faceExp;

    /**
     * 附件
     */
    private String filePath;

}
