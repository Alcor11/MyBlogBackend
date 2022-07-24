package com.alcor.tobacco.service;

import com.alcor.tobacco.domain.DocInfo;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author guchun
 * @description TODO
 * @date 2022/7/11 22:11
 */

@SpringBootTest
class DocInfoServiceTest {

    @Resource
    DocInfoService service;

    @Test
    void queryList() {
        DocInfoQuery query = new DocInfoQuery();
        List<DocInfo> docInfos = service.queryList(query);
        Iterator<DocInfo> iterator = docInfos.iterator();
        while (iterator.hasNext()) {
            DocInfo next = iterator.next();
            System.out.println(next.toString());
        }
    }
}