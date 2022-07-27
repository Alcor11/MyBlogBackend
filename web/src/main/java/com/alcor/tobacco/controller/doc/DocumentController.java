package com.alcor.tobacco.controller.doc;

import com.alcor.tobacco.domain.entity.DocCont;
import com.alcor.tobacco.domain.query.DocInfoQuery;
import com.alcor.tobacco.domain.vo.DocInfoVO;
import com.alcor.tobacco.response.BaseResponse;
import com.alcor.tobacco.service.DocContService;
import com.alcor.tobacco.service.DocInfoService;
import com.alcor.tobacco.utils.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author guchun
 * @description 文章列表controller
 * @date 2022/7/9 00:52
 */
@RestController
@RequestMapping("/api/article")
public class DocumentController {

    @Resource
    DocInfoService docInfoService;

    @Resource
    DocContService docContService;

    /**
     * 获取文章列表摘要显示在首页
     * @param query query entity
     * @return article list
     */
    @PostMapping("/list")
    public BaseResponse<List<DocInfoVO>> getArticlesInfo(@RequestBody DocInfoQuery query) {
        List<DocInfoVO> list = docInfoService.queryDocVoList(query);

        return ResultUtils.success(list);
    }

    @GetMapping("/doc")
    public DocCont getDocContent(@RequestParam("id") String docGuid) {
        return docContService.getDocContByGuid(docGuid);
    }
}
