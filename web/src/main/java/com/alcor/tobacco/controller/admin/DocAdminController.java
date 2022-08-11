package com.alcor.tobacco.controller.admin;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.domain.vo.NewDocVO;
import com.alcor.tobacco.response.BaseResponse;
import com.alcor.tobacco.service.DocInfoService;
import com.alcor.tobacco.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author guchun
 * @description 管理平台文档接口控制类
 * @date 2022/7/28 00:21
 */
@RequestMapping("/api/doc")
public class DocAdminController {

    // TODO 管理平台文档增删改查
    @Resource
    DocInfoService docInfoService;

    @PostMapping("add")
    public BaseResponse<Integer> insertNewDoc(@RequestBody NewDocVO newDocVO) {
        int i = docInfoService.addNewDocInfoAndCont(newDocVO);
        if (i == 1) {
            return ResultUtils.success(i);
        }
        return ResultUtils.error(ResCodeEnum.SYSTEM_ERROR, "添加失败");
    }

    @GetMapping("del")
    public BaseResponse<Integer> delDoc(@RequestParam(value = "docGuid") String docGuid) {
        int i = docInfoService.deleteDocByDocGuid(docGuid);
        if (i == 1) {
            return ResultUtils.success(i);
        }
        return ResultUtils.error(ResCodeEnum.SYSTEM_ERROR, "删除失败");
    }

    
}

