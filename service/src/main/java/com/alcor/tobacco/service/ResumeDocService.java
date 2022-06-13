package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.ResumeDoc;
import com.alcor.tobacco.domain.vo.Resume;
import com.alcor.tobacco.domain.vo.ResumeVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author guchun
* @description 针对表【resume_doc】的数据库操作Service
* @createDate 2022-06-09 19:31:46
*/
public interface ResumeDocService extends IService<ResumeDoc> {

    /**
     * 根据登陆用户获取全部投递记录
     * @param loginUser 登陆用户信息
     * @return 投递记录对象
     */
    ResumeVo getResumeListByLoginUser(LoginUser loginUser);

    /**
     * 增加一条记录
     * @param loginUser 登陆用户信息
     * @param resume 投递信息
     * @return 增加条数
     */
    int addResumeData(LoginUser loginUser, Resume resume);


}
