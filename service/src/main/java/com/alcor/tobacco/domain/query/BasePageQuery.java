package com.alcor.tobacco.domain.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author guchun
 * @description TODO
 * @date 2022/7/11 21:04
 */
public abstract class BasePageQuery<T> extends BaseQuery<T> {
    // 当前页
    public Integer pageNum = 1;
    // 每页显示的总条数
    public Integer pageSize = 5;

    public String orderStr;

    @JsonIgnore
    public Page buildPage(){
        if(pageNum==null){
            pageNum = 1;
        }
        if(pageSize==null){
            pageSize = 10;
        }
        return new Page<T>(this.pageNum,this.pageSize);
    }
}
