package com.xxp.pc_admin.controller;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 文章控制器
 * @author: xxp
 * @create: 2020-10-14 21:22
 */
@RestController
@RequestMapping("/admin/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public PageResult getList(
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("query") String query,
            @RequestParam("creator") String creator,
            @RequestParam("tittle") String tittle) {
        return articleService.getList(page, pageSize, query, creator,tittle);
    }
}
