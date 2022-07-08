package com.alcor.tobacco.controller.doc;

import com.alcor.tobacco.domain.query.ArticleQuery;
import com.alcor.tobacco.domain.vo.ArticlesInfoVO;
import com.alcor.tobacco.response.BaseResponse;
import com.alcor.tobacco.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guchun
 * @description TODO
 * @date 2022/7/9 00:52
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {


    public BaseResponse<List<ArticlesInfoVO>> getArticlesInfo(@RequestBody ArticleQuery query) {



        return ResultUtils.success(null);
    }
}
