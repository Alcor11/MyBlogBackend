package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.domain.ResumeContent;
import com.alcor.tobacco.domain.ResumeDoc;
import com.alcor.tobacco.domain.vo.ResumeContentVO;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.mapper.ResumeContentMapper;
import com.alcor.tobacco.mapstruct.ResumeContentMap;
import com.alcor.tobacco.service.ResumeContentService;
import com.alcor.tobacco.service.ResumeDocService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.Executor;

/**
* @author guchun
* @description 针对表【resume_content】的数据库操作Service实现
* @createDate 2022-06-10 21:29:24
*/
@Service
public class ResumeContentServiceImpl extends ServiceImpl<ResumeContentMapper, ResumeContent>
    implements ResumeContentService {

    @Resource
    ResumeDocService resumeDocService;

    @Resource
    ResumeContentMap map;

    @Override
    public int addResumeContentData(ResumeContentVO resumeContentVO) {
        Integer id = resumeContentVO.getResumeId();
        ResumeDoc resumeDoc = resumeDocService.getById(id);
        if (ObjectUtils.isEmpty(resumeDoc)) {
            throw new BusinessException(ResCodeEnum.NULL_ERROR, "请求的主词条不存在");
        }
        ResumeContent resumeContent = map.voToDo(resumeContentVO);
        boolean save = this.save(resumeContent);
        if (save) {
            return 1;
        }
        return -1;
    }

    @Override
    public List<ResumeContentVO> getResumeContentListByResumeId(Long id) {
        List<ResumeContentVO> ret = new ArrayList<>();
        QueryWrapper<ResumeContent> wrapper = new QueryWrapper<>();
        wrapper.eq("resume_id", id);
        List<ResumeContent> list = this.list(wrapper);
        list.forEach(resumeContent -> ret.add(map.doToVo(resumeContent)));
        if (ret.size() > 0) {
            return ret;
        }
        return null;
    }
}




