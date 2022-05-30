package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.SysUser;
import com.alcor.tobacco.domain.dto.UserRegisterDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author guchun
* @description 针对表【sys_user(系统用户)】的数据库操作Service
* @createDate 2022-05-26 21:44:21
*/
public interface SysUserService extends IService<SysUser> {

    long userRegister(UserRegisterDTO userRegisterDTO);

}
