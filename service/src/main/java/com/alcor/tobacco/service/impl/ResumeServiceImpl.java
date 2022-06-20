package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.vo.Resume;
import com.alcor.tobacco.domain.vo.ResumeBO;
import com.alcor.tobacco.domain.vo.ResumeTreeVO;
import com.alcor.tobacco.domain.vo.ResumeVo;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.service.ResumeContentService;
import com.alcor.tobacco.service.ResumeDocService;
import com.alcor.tobacco.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guchun
 * @description resume service impl
 * @date 2022/6/13 19:46
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Resource
    ResumeDocService docService;

    @Resource
    ResumeContentService contentService;

    @Override
    public ResumeTreeVO getResumeTree(LoginUser loginUser) {
        ResumeTreeVO resumeTree = new ResumeTreeVO();
        ResumeVo resumeListVo = docService.getResumeListByLoginUser(loginUser);
        List<Resume> resumeList = resumeListVo.getResumeList();
        List<ResumeBO> resumeBOList = new ArrayList<>();
        if (resumeList == null || resumeList.size() == 0) {
            throw new BusinessException(ResCodeEnum.NULL_ERROR, "没有数据");
        }
        resumeList.forEach(item -> {
            ResumeBO resumeBO = new ResumeBO();
            long id = item.getId();
            resumeBO.setResume(item);
            resumeBO.setContents(contentService.getResumeContentListByResumeId(id));
            resumeBOList.add(resumeBO);
        });

        resumeTree.setResumeTree(resumeBOList);
        return resumeTree;
    }
}
