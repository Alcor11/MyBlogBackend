package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.vo.ResumeTreeVO;

import java.util.List;

/**
 * @author guchun
 * @description resume对外接口类
 * @date 2022/6/13 19:45
 */
public interface ResumeService {

    ResumeTreeVO getResumeTree(LoginUser loginUser);
}
