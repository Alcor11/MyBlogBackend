package com.alcor.tobacco.controller.sys;

import com.alcor.tobacco.aspectlj.config.TokenVerify;
import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.controller.BaseController;
import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.dto.UserLoginDTO;
import com.alcor.tobacco.domain.dto.UserRegisterDTO;
import com.alcor.tobacco.domain.vo.UserLoginVO;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.response.BaseResponse;
import com.alcor.tobacco.service.SysUserService;
import com.alcor.tobacco.utils.ResultUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author guchun
 * @description auth controller
 * @date 2022/5/30 20:14
 */
@RestController
@RequestMapping("/api/auth")
public class UserController extends BaseController {

    @Resource
    SysUserService userService;

    @PostMapping("register")
    public BaseResponse<Long> register(@RequestBody UserRegisterDTO userRegisterDTO) {

        if (!StringUtils.hasText(userRegisterDTO.getUsername()) || !StringUtils.hasText(userRegisterDTO.getPassword())) {
            throw new BusinessException(ResCodeEnum.NULL_ERROR);
        }
        if (userRegisterDTO.isValid()) {
            throw new BusinessException(ResCodeEnum.PARAMS_ERROR);
        }
        long res = userService.userRegister(userRegisterDTO);

        return ResultUtils.success(res);
    }

    @PostMapping("login")
    public BaseResponse<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {

        if (!StringUtils.hasText(userLoginDTO.getPassword()) || !StringUtils.hasText(userLoginDTO.getUsername())) {
            throw new BusinessException(ResCodeEnum.NULL_ERROR);
        }

        UserLoginVO userLoginVO = userService.userLogin(userLoginDTO);

        return ResultUtils.success(userLoginVO);
    }

    @GetMapping("/current")
    public BaseResponse<LoginUser> currentUserInfo(HttpServletRequest httpServletRequest) {
        LoginUser loginUser = super.getLoginUser(httpServletRequest);
        return ResultUtils.success(loginUser);
    }


    @GetMapping("/offline")
    @TokenVerify
    public BaseResponse offLine(HttpServletRequest httpServletRequest) {
        boolean b = super.offLineUser(httpServletRequest);
        return b ? ResultUtils.success("下线成功") : ResultUtils.success("下线失败或已下线");
    }


}
