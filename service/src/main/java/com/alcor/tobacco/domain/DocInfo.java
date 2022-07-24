package com.alcor.tobacco.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName doc_info
 */
@TableName(value ="doc_info")
@Data
public class DocInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String updateBy;

    /**
     * 
     */
    private String idDelete;

    /**
     * 审核
     */
    private String isPermit;

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
        DocInfo other = (DocInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getDocDesc() == null ? other.getDocDesc() == null : this.getDocDesc().equals(other.getDocDesc()))
            && (this.getDocGuid() == null ? other.getDocGuid() == null : this.getDocGuid().equals(other.getDocGuid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getIdDelete() == null ? other.getIdDelete() == null : this.getIdDelete().equals(other.getIdDelete()))
            && (this.getIsPermit() == null ? other.getIsPermit() == null : this.getIsPermit().equals(other.getIsPermit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getDocDesc() == null) ? 0 : getDocDesc().hashCode());
        result = prime * result + ((getDocGuid() == null) ? 0 : getDocGuid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getIdDelete() == null) ? 0 : getIdDelete().hashCode());
        result = prime * result + ((getIsPermit() == null) ? 0 : getIsPermit().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", tag=").append(tag);
        sb.append(", desc=").append(docDesc);
        sb.append(", docGuid=").append(docGuid);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", idDelete=").append(idDelete);
        sb.append(", isPermit=").append(isPermit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}