package com.alcor.tobacco.mapstruct;

import com.alcor.tobacco.domain.ResumeDoc;
import com.alcor.tobacco.domain.vo.Resume;
import org.mapstruct.Mapper;

/**
 * @author guchun
 * @description TODO
 * @date 2022/6/9 21:24
 */
@Mapper(componentModel = "spring")
public interface ResumeDocMap {

    Resume doToBo(ResumeDoc resumeDoc);

    ResumeDoc boToDo(Resume resume);
}
