package com.xxp.pc_admin.controller;

import cn.hutool.json.JSONUtil;
import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.constant.MqConstant;
import com.xxp.pc_admin.domain.Article;
import com.xxp.pc_admin.domain.HotArticle;
import com.xxp.pc_admin.dto.TagDto;
import com.xxp.pc_admin.service.ArticleService;
import com.xxp.pc_admin.service.HotArticleService;
import com.xxp.pc_admin.service.TagService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @description: 热门控制器
 * @author: xxp
 * @create: 2020-10-22 20:56
 */
@RestController
@RequestMapping("/admin/hot")
public class HotController {
    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;
    private static final String HOT_TAG = "HotTag:";
    private static final String HOTARTICLE = "HotArticle:";
    @Autowired
    private StringRedisTemplate srt;
    @Autowired
    private AmqpTemplate at;

    @Autowired
    private HotArticleService hotArticleService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/tags")
    public Result getHotTag() {
        BoundZSetOperations<String, String> stringStringBoundZSetOperations = srt.boundZSetOps(HOT_TAG);
        Set<String> strings = stringStringBoundZSetOperations.reverseRange(0, 10);
        List<TagDto> tagDtos = new ArrayList<>();
        for (String string : strings) {
            TagDto tagDto = JSONUtil.toBean(string, TagDto.class);
            tagDtos.add(tagDto);
        }
        return Result.success(tagDtos, "查找热门标签成功!");
    }

    @GetMapping("/refreshTags")
    public Result refreshTags() {
        at.convertAndSend(MqConstant.Hot_TAG_EXCHANGE, MqConstant.Tag_ROUTING_KEY_REFRESH, true);
        return Result.successWithNoData("刷新成功!");
    }

    @GetMapping("/refreshArticles")
    public Result refreshArticles() {
        at.convertAndSend(MqConstant.ARTICLE_EXCHANGE, MqConstant.ARTICLE_ROUTING_KEY_REFRESH, true);
        return Result.successWithNoData("刷新成功!");
    }

    @GetMapping("/articles")
    public Result getHotArticles() {
        BoundZSetOperations<String, String> zSetOperations = srt.boundZSetOps(HOTARTICLE);
        Set<String> strings = zSetOperations.reverseRange(0, 9);
        List<HotArticle> hotArticles = new ArrayList<>();
        for (String string : strings) {
            HotArticle hotArticle = JSONUtil.toBean(string, HotArticle.class);
            hotArticles.add(hotArticle);
        }
        return Result.success(hotArticles, "查找热门文章成功!");
    }

    @GetMapping("/articleWeight")
    public PageResult getArticleWeight(
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("query") String query
    ) {
        return hotArticleService.getList(page, pageSize, query);
    }

    @PostMapping("/addWeight/{id}")
    public Result addWeight(@PathVariable("id") Integer id) {
        HotArticle hotArticle = hotArticleService.selectByPrimaryKey(id);
        if (hotArticle != null) {
            return Result.fail("该文章已存在权重信息,请到权重菜单做相关操作!");
        }
        Article article = articleService.selectByPrimaryKey(id);
        HotArticle hotArticle1 = new HotArticle();
        hotArticle1.setArticleId(id);
        hotArticle1.setTittle(article.getTittle());
        hotArticle1.setWeights(0L);
        hotArticleService.insertSelective(hotArticle1);
        return Result.successWithNoData("添加成功!");
    }

    @PutMapping("/editArticleWeight")
    public Result editArticleWeight(@RequestBody HotArticle hotArticle) {
        hotArticleService.updateByPrimaryKeySelective(hotArticle);
        return Result.successWithNoData("修改成功!");
    }

    @DeleteMapping("/deleteWeight/{id}")
    public Result deleteWeight(@PathVariable("id") Integer id) {
        hotArticleService.deleteByPrimaryKey(id);
        return Result.successWithNoData("删除成功!");
    }
}
