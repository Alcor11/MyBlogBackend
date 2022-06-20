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

    /**
     * 添加一条投递进展内容
     * @param resumeContentVO 投递进展vo
     * @return 是否成功
     */
    int addResumeContentData(ResumeContentVO resumeContentVO);

    /**
     * 根据投递编号获得全部进展list
     * @param id 投递编号
     * @return list
     */
    List<ResumeContentVO> getResumeContentListByResumeId(Long id);

}
