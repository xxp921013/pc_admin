package com.xxp.pc_admin.controller;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.service.RoundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 回复控制器
 * @author: xxp
 * @create: 2020-10-15 15:35
 */
@RestController
@RequestMapping("/admin/round")
public class RoundController {
    @Autowired
    private RoundsService roundsService;

    @GetMapping("/list")
    public PageResult getList(
            @RequestParam(value = "creator", required = false) String creator,
            @RequestParam("articleId") Integer articleId,
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize) {
        return roundsService.getList(creator, articleId, page, pageSize);
    }
}
