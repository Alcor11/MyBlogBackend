package com.alcor.tobacco.mapper;

import com.alcor.tobacco.domain.entity.DocInfo;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author guchun
* @description 针对表【doc_info】的数据库操作Mapper
* @createDate 2022-07-09 00:45:57
* @Entity com.alcor.tobacco.domain.entity.DocInfo
*/
public interface DocInfoMapper extends BaseMapper<DocInfo> {

    List<DocInfo> list(@Param(Constants.WRAPPER) QueryWrapper qw, @Param("query") DocInfoQuery query);

}




