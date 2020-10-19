package com.xxp.pc_admin.controller;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.domain.Tag;
import com.xxp.pc_admin.service.ArticleService;
import com.xxp.pc_admin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public PageResult getList(
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("query") String query,
            @RequestParam("creator") String creator,
            @RequestParam("tittle") String tittle) {
        return articleService.getList(page, pageSize, query, creator, tittle);
    }

    @GetMapping("/tagList")
    public PageResult getTagList(@RequestParam("page") Integer page,
                                 @RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("query") String query) {
        return tagService.getList(page, pageSize, query);
    }

    @PostMapping("/addTag")
    public Result addTag(@RequestBody Tag tag) {
        tagService.insertSelective(tag);
        return Result.successWithNoData("添加成功!");
    }
}
