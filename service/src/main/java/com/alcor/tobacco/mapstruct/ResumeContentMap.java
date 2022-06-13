package com.alcor.tobacco.mapstruct;

import com.alcor.tobacco.domain.ResumeContent;
import com.alcor.tobacco.domain.vo.ResumeContentVO;
import org.mapstruct.Mapper;

/**
 * @author guchun
 * @description TODO
 * @date 2022/6/13 20:01
 */
@Mapper(componentModel = "spring")
public interface ResumeContentMap {

    ResumeContent voToDo(ResumeContentVO resumeContentVO);

    ResumeContentVO doToVo(ResumeContent resumeContent);

}
