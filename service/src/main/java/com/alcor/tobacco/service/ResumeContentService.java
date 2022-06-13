package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.ResumeContent;
import com.alcor.tobacco.domain.vo.ResumeContentVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author guchun
* @description 针对表【resume_content】的数据库操作Service
* @createDate 2022-06-10 21:29:24
*/
public interface ResumeContentService extends IService<ResumeContent> {

    int addResumeContentData(ResumeContentVO resumeContentVO);

    List<ResumeContentVO> getResumeContentListByResumeId(Long id);
}
