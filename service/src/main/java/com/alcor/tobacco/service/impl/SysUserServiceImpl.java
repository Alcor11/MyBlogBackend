package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.domain.SysUser;
import com.alcor.tobacco.domain.dto.UserRegisterDTO;
import com.alcor.tobacco.mapper.SysUserMapper;
import com.alcor.tobacco.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
* @author guchun
* @description 针对表【sys_user(系统用户)】的数据库操作Service实现
* @createDate 2022-05-26 21:44:21
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {

    @Override
    public long userRegister(UserRegisterDTO userRegisterDTO) {
        return 0;
    }
}




