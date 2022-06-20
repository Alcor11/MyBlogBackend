package com.alcor.tobacco.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName resume_content
 */
@TableName(value ="resume_content")
@Data
public class ResumeContent implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ResumeContent other = (ResumeContent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getResumeContent() == null ? other.getResumeContent() == null : this.getResumeContent().equals(other.getResumeContent()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getResumeStatus() == null ? other.getResumeStatus() == null : this.getResumeStatus().equals(other.getResumeStatus()))
            && (this.getFaceExp() == null ? other.getFaceExp() == null : this.getFaceExp().equals(other.getFaceExp()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getResumeContent() == null) ? 0 : getResumeContent().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getResumeStatus() == null) ? 0 : getResumeStatus().hashCode());
        result = prime * result + ((getFaceExp() == null) ? 0 : getFaceExp().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", resumeContent=").append(resumeContent);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", resumeStatus=").append(resumeStatus);
        sb.append(", faceExp=").append(faceExp);
        sb.append(", filePath=").append(filePath);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}