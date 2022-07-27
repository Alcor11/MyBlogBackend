package com.alcor.tobacco;

import com.alcor.tobacco.domain.entity.DocCont;
import com.alcor.tobacco.domain.entity.DocInfo;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import com.alcor.tobacco.domain.vo.ResumeContentVO;
import com.alcor.tobacco.mapper.DocInfoMapper;
import com.alcor.tobacco.service.DocContService;
import com.alcor.tobacco.service.DocInfoService;
import com.alcor.tobacco.service.ResumeContentService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class TobaccoApplicationTests {

//    @Autowired
//    ResumeDocService docService;

    @Resource
    DocInfoService service;

    @Resource
    DocInfoMapper mapper;

    /**
     * 分页查询test
     */
    @Test
    void queryList() {

        DocInfoQuery query = new DocInfoQuery();
        // tag
        query.setTag("2");
        // 页数
        query.pageNum = 1;
        // size
        query.pageSize = 5;
        List<DocInfo> docInfos = service.queryList(query);
        Iterator<DocInfo> iterator = docInfos.iterator();
        while (iterator.hasNext()) {
            DocInfo next = iterator.next();
            System.out.println(next.toString());
        }
    }

    @Resource
    DocContService docContService;
    @Test
    void queryArticleContTest() {
        DocCont docContByGuid = docContService.getDocContByGuid("1");
        Assertions.assertNotNull(docContByGuid);
        System.out.println(docContByGuid.toString());
    }


    @Test
    void contextLoads() {
//        LoginUser loginUser = new LoginUser();
//        SysUser sysUser = new SysUser();
//        sysUser.setUserId((long)3);
//        loginUser.setUser(sysUser);
//        Resume resume = new Resume("testcom2", new Date(), "test2", "111@qwe.co2m");
//
////        docService.addResumeData(loginUser, resume);
//
//        ResumeVo resumeListByLoginUser = docService.getResumeListByLoginUser(loginUser);
//        resumeListByLoginUser.getResumeList().stream().forEach((e) -> {
//            System.out.println(e.getComName());
//            System.out.println(e.getNetData());
//        });
//        Assert.assertNotNull(resumeListByLoginUser);
    }

    @Test
    void getResumeDoc() {
//        ResumeDoc byId = docService.getById(3);
//        System.out.println(byId.toString());
    }


    @Test
    void deleteTest() {
//        boolean b = docService.removeById(1);
//        Assert.assertEquals(b, true);
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
