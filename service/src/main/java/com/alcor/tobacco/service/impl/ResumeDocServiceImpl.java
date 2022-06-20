package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.ResumeDoc;
import com.alcor.tobacco.domain.vo.Resume;
import com.alcor.tobacco.domain.vo.ResumeVo;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.mapper.ResumeDocMapper;
import com.alcor.tobacco.mapstruct.ResumeDocMap;
import com.alcor.tobacco.service.ResumeDocService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
* @author guchun
* @description 针对表【resume_doc】的数据库操作Service实现
* @createDate 2022-06-09 19:31:46
*/
@Service
public class ResumeDocServiceImpl extends ServiceImpl<ResumeDocMapper, ResumeDoc>
    implements ResumeDocService {

    @Resource
    ResumeDocMapper mapper;

    @Resource
    ResumeDocMap map;

    @Override
    public ResumeVo getResumeListByLoginUser(LoginUser loginUser) {
        QueryWrapper<ResumeDoc> wrapper = new QueryWrapper<>();
        wrapper.eq("submit_user", loginUser.getUser().getUserId());
        List<ResumeDoc> resumeDocs = mapper.selectList(wrapper);
        List<Resume> resumes = new ArrayList<>();
        for (ResumeDoc o : resumeDocs) {
            Resume resume = map.doToBo(o);
            resume.setId(o.getId());
            resumes.add(resume);
        }
        return new ResumeVo(resumes);
    }

    @Override
    public int addResumeData(LoginUser loginUser, Resume resume) {
        ResumeDoc resumeDoc = map.boToDo(resume);
        resumeDoc.setSubmitUser(loginUser.getUser().getUserId());
        boolean save = this.save(resumeDoc);
        if (!save) {
            throw new BusinessException(ResCodeEnum.SYSTEM_ERROR, "插入错误");
        }
        return 1;
    }

}




