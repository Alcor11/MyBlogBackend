package com.alcor.tobacco.domain.query;

import com.alcor.tobacco.aspectlj.config.MyQuery;
import com.alcor.tobacco.domain.DocInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guchun
 * @description TODO
 * @date 2022/7/11 22:01
 */
@Data
@NoArgsConstructor
public class DocInfoQuery extends BasePageQuery{

    @MyQuery(value = BaseQuery.eq, column = "tag")
    private String tag;

}
