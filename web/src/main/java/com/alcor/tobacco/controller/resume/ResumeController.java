package com.alcor.tobacco.controller.resume;

import com.alcor.tobacco.aspectlj.config.TokenVerify;
import com.alcor.tobacco.controller.BaseController;
import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.vo.ResumeTreeVO;
import com.alcor.tobacco.domain.vo.ResumeVo;
import com.alcor.tobacco.response.BaseResponse;
import com.alcor.tobacco.service.ResumeDocService;
import com.alcor.tobacco.service.ResumeService;
import com.alcor.tobacco.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author guchun
 * @description 投递controller
 * @date 2022/6/13 19:51
 */
@RestController
@RequestMapping("/api/resume")
public class ResumeController extends BaseController {

    @Resource
    ResumeService resumeService;

    @TokenVerify
    @GetMapping("/myResume")
    public BaseResponse<ResumeTreeVO> getUserResume(HttpServletRequest httpServletRequest) {
        LoginUser loginUser = this.getLoginUser(httpServletRequest);
        ResumeTreeVO resumeTree = resumeService.getResumeTree(loginUser);
        return ResultUtils.success(resumeTree);
    }


}
