package com.alcor.tobacco.mapstruct;

import com.alcor.tobacco.domain.entity.DocInfo;
import com.alcor.tobacco.domain.vo.DocInfoVO;
import com.alcor.tobacco.domain.vo.NewDocVO;
import org.mapstruct.Mapper;

/**
 * @author guchun
 * @description doc info mapstruct
 * @date 2022/7/24 22:49
 */
@Mapper(componentModel = "spring")
public interface DocInfoMap {

    DocInfoVO doToVo(DocInfo docInfo);

    DocInfo ndVoToDo(NewDocVO newDocVO);
}
