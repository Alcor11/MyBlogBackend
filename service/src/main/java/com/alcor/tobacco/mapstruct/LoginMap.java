package com.alcor.tobacco.mapstruct;

import com.alcor.tobacco.domain.SysUser;
import com.alcor.tobacco.domain.vo.UserLoginVO;
import org.mapstruct.Mapper;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 19:53
 */
@Mapper(componentModel = "spring")
public interface LoginMap {

    UserLoginVO doToVo(SysUser sysUser);

}
