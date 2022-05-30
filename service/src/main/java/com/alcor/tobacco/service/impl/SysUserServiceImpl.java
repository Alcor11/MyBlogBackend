package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.SysUser;
import com.alcor.tobacco.domain.dto.UserLoginDTO;
import com.alcor.tobacco.domain.dto.UserRegisterDTO;
import com.alcor.tobacco.domain.vo.UserLoginVO;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.mapstruct.LoginMap;
import com.alcor.tobacco.mapper.SysUserMapper;
import com.alcor.tobacco.mapstruct.UserRegisterMap;
import com.alcor.tobacco.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

import static com.alcor.tobacco.constant.UserConstant.SALT;

/**
* @author guchun
* @description 针对表【sys_user(系统用户)】的数据库操作Service实现
* @createDate 2022-05-26 21:44:21
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {

    @Resource
    SysUserMapper userMapper;

    @Resource
    UserRegisterMap map;

    @Resource
    LoginMap loginMap;

    @Resource
    TokenService tokenService;

    @Override
    public long userRegister(UserRegisterDTO userRegisterDTO) {
        String username = userRegisterDTO.getUsername();
        String password = userRegisterDTO.getPassword();

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        long count = userMapper.selectCount(wrapper);
        if (count > 0) {
            throw new BusinessException(ResCodeEnum.PARAMS_ERROR, "账号已存在");
        }

        userRegisterDTO.setPassword(getDigestPassword(password));
        System.out.println(userRegisterDTO.getPassword());
        SysUser sysUser = map.dtoToDo(userRegisterDTO);
        System.out.println(sysUser.toString());
        boolean isSave = this.save(sysUser);
        if (!isSave) {
            throw new BusinessException(ResCodeEnum.SYSTEM_ERROR, "创建失败");
        }
        return sysUser.getUserId();

    }

    @Override
    public UserLoginVO userLogin(UserLoginDTO loginDTO) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        wrapper.eq("username", loginDTO.getUsername());
        wrapper.eq("password", getDigestPassword(loginDTO.getPassword()));
        SysUser sysUser = userMapper.selectOne(wrapper);

        if (ObjectUtils.isEmpty(sysUser)) {
            throw new BusinessException(ResCodeEnum.PARAMS_ERROR, "账户名或密码错误");
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setUser(sysUser);

        UserLoginVO userLoginVO = loginMap.doToVo(sysUser);
        userLoginVO.setToken(tokenService.createToken(loginUser));

        return userLoginVO;
    }


    private String getDigestPassword(String userPassword) {

        return DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());

    }
}




