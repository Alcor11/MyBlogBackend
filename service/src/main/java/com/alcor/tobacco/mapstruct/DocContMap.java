package com.alcor.tobacco.mapstruct;

import com.alcor.tobacco.domain.entity.DocCont;
import com.alcor.tobacco.domain.vo.NewDocVO;
import org.mapstruct.Mapper;

/**
 * @author guchun
 * @description TODO
 * @date 2022/8/11 23:17
 */
@Mapper(componentModel = "spring")
public interface DocContMap {

    DocCont voToDo(NewDocVO newDocVO);
}
