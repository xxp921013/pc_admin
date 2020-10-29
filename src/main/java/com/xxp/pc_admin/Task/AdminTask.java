package com.xxp.pc_admin.Task;

import com.xxp.pc_admin.domain.DailyLog;
import com.xxp.pc_admin.service.DailyLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 后台定时任务
 * @author: xxp
 * @create: 2020-10-28 20:38
 */
@Component
@Slf4j
public class AdminTask {
    @Autowired
    private DailyLogService dailyLogService;

    @Scheduled(cron = "0 0 0 * * ? ")
    public void recordLog() {
        System.out.println("执行每日数据记录");
        DailyLog daily = dailyLogService.getDaily();
        int i = dailyLogService.insertSelective(daily);
        if (i != 0) {
            dailyLogService.emptyToday();
        }

    }
}
