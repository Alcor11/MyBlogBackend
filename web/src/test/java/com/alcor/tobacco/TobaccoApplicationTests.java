package com.alcor.tobacco;

import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.domain.SysUser;
import com.alcor.tobacco.domain.vo.Resume;
import com.alcor.tobacco.domain.vo.ResumeVo;
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
    void deleteTest() {
        boolean b = docService.removeById(1);
        Assert.assertEquals(b, true);
    }

}
