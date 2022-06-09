package com.alcor.tobacco.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName resume_doc
 */
@TableName(value ="resume_doc")
@Data
public class ResumeDoc implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

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

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 
     */
    private String isDelete;

    /**
     * 
     */
    private Long submitUser;

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
        ResumeDoc other = (ResumeDoc) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComName() == null ? other.getComName() == null : this.getComName().equals(other.getComName()))
            && (this.getResuDate() == null ? other.getResuDate() == null : this.getResuDate().equals(other.getResuDate()))
            && (this.getSubmitFunc() == null ? other.getSubmitFunc() == null : this.getSubmitFunc().equals(other.getSubmitFunc()))
            && (this.getNetData() == null ? other.getNetData() == null : this.getNetData().equals(other.getNetData()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getSubmitUser() == null ? other.getSubmitUser() == null : this.getSubmitUser().equals(other.getSubmitUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComName() == null) ? 0 : getComName().hashCode());
        result = prime * result + ((getResuDate() == null) ? 0 : getResuDate().hashCode());
        result = prime * result + ((getSubmitFunc() == null) ? 0 : getSubmitFunc().hashCode());
        result = prime * result + ((getNetData() == null) ? 0 : getNetData().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getSubmitUser() == null) ? 0 : getSubmitUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comName=").append(comName);
        sb.append(", resuDate=").append(resuDate);
        sb.append(", submitFunc=").append(submitFunc);
        sb.append(", netData=").append(netData);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", submitUser=").append(submitUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}