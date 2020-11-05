package com.xxp.pc_admin.controller;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.domain.DailyLog;
import com.xxp.pc_admin.service.DailyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @description: 每日数据控制器
 * @author: xxp
 * @create: 2020-10-28 21:15
 */
@RestController
@RequestMapping("/admin/daily")
public class DailyLogController {
    @Autowired
    private DailyLogService dailyLogService;

    @Autowired
    private StringRedisTemplate srt;

    @GetMapping("/list")
    public PageResult getList(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        return dailyLogService.getList(page, pageSize);
    }

    @GetMapping("/today")
    public Result getToday() {
        DailyLog dailyLog = dailyLogService.getDaily();
        return Result.success(dailyLog, "获取当日数据成功!");
    }

    @GetMapping("/loginUser")
    public Result getLoginUser() {
        Set keys = srt.keys("spring:session:index*");
        return Result.success(keys.size(), "获取当前登陆用户数成功!");
    }
}
