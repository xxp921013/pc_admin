package com.xxp.pc_admin.controller;

import cn.hutool.json.JSONUtil;
import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.constant.MqConstant;
import com.xxp.pc_admin.dto.TagDto;
import com.xxp.pc_admin.service.ArticleService;
import com.xxp.pc_admin.service.TagService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private StringRedisTemplate srt;
    @Autowired
    private AmqpTemplate at;

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


}
