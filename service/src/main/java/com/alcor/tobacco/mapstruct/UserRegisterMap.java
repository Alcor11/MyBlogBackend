package com.alcor.tobacco.mapstruct;

import com.alcor.tobacco.domain.SysUser;
import com.alcor.tobacco.domain.dto.UserRegisterDTO;
import org.mapstruct.Mapper;

/**
 * @author guchun
 * @description 用户注册map
 * @date 2022/5/30 18:56
 */

@Mapper(componentModel = "spring")
public interface UserRegisterMap {

    UserRegisterDTO doToDto(SysUser sysUser);

    SysUser dtoToDo(UserRegisterDTO userRegisterDTO);

}
