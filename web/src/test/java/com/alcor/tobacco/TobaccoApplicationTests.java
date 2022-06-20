package com.alcor.tobacco;

import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.ResumeDoc;
import com.alcor.tobacco.domain.SysUser;
import com.alcor.tobacco.domain.vo.Resume;
import com.alcor.tobacco.domain.vo.ResumeContentVO;
import com.alcor.tobacco.domain.vo.ResumeVo;
import com.alcor.tobacco.service.ResumeContentService;
import com.alcor.tobacco.service.ResumeDocService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class TobaccoApplicationTests {

    @Autowired
    ResumeDocService docService;

    @Test
    void contextLoads() {
        LoginUser loginUser = new LoginUser();
        SysUser sysUser = new SysUser();
        sysUser.setUserId((long)3);
        loginUser.setUser(sysUser);
        Resume resume = new Resume("testcom2", new Date(), "test2", "111@qwe.co2m");

//        docService.addResumeData(loginUser, resume);

        ResumeVo resumeListByLoginUser = docService.getResumeListByLoginUser(loginUser);
        resumeListByLoginUser.getResumeList().stream().forEach((e) -> {
            System.out.println(e.getComName());
            System.out.println(e.getNetData());
        });
        Assert.assertNotNull(resumeListByLoginUser);
    }

    @Test
    void getResumeDoc() {
        ResumeDoc byId = docService.getById(3);
        System.out.println(byId.toString());
    }


    @Test
    void deleteTest() {
        boolean b = docService.removeById(1);
        Assert.assertEquals(b, true);
    }

    @Autowired
    ResumeContentService contentService;

    @Test
    void insertContentTest() {
        ResumeContentVO resumeContentVO = new ResumeContentVO();
        resumeContentVO.setResumeContent("this is my first commit");
        resumeContentVO.setResumeId(3);
        resumeContentVO.setFaceExp("# my exp" +
                "## test" +
                "### commit");
        resumeContentVO.setResumeStatus(1);
        int i = contentService.addResumeContentData(resumeContentVO);
        Assert.assertEquals(i, 1);
    }

}
