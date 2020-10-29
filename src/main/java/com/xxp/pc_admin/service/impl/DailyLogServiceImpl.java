package com.xxp.pc_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.constant.RedisPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.xxp.pc_admin.domain.DailyLogExample;
import com.xxp.pc_admin.dao.DailyLogMapper;
import com.xxp.pc_admin.domain.DailyLog;
import com.xxp.pc_admin.service.DailyLogService;

@Service
public class DailyLogServiceImpl implements DailyLogService {

    @Resource
    private DailyLogMapper dailyLogMapper;
    @Autowired
    private StringRedisTemplate srt;

    @Override
    public long countByExample(DailyLogExample example) {
        return dailyLogMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(DailyLogExample example) {
        return dailyLogMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dailyLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DailyLog record) {
        return dailyLogMapper.insert(record);
    }

    @Override
    public int insertSelective(DailyLog record) {
        return dailyLogMapper.insertSelective(record);
    }

    @Override
    public List<DailyLog> selectByExample(DailyLogExample example) {
        return dailyLogMapper.selectByExample(example);
    }

    @Override
    public DailyLog selectByPrimaryKey(Integer id) {
        return dailyLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(DailyLog record, DailyLogExample example) {
        return dailyLogMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(DailyLog record, DailyLogExample example) {
        return dailyLogMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(DailyLog record) {
        return dailyLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DailyLog record) {
        return dailyLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult getList(Integer page, Integer pageSize) {
        if (page == null || page == 0) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        DailyLogExample dailyLogExample = new DailyLogExample();
        dailyLogExample.or().andDateIsNotNull();
        List<DailyLog> dailyLogs = dailyLogMapper.selectByExample(dailyLogExample);
        PageInfo<DailyLog> dailyLogPageInfo = new PageInfo<>(dailyLogs);
        return PageResult.success("查找成功!", dailyLogs, (int) dailyLogPageInfo.getTotal());
    }

    @Override
    public DailyLog getDaily() {
        DailyLog dailyLog = new DailyLog();
        dailyLog.setArticle(Long.valueOf(srt.boundValueOps(RedisPrefix.TODAY_ARTICLE_ADD).get()));
        dailyLog.setArticleRead(Long.valueOf(srt.boundValueOps(RedisPrefix.TODAY_ARTICLE_READ).get()));
        dailyLog.setDate(new Date());
        dailyLog.setLoginuser(srt.boundSetOps(RedisPrefix.TODAY_LOGIN_USER).size());
        dailyLog.setNewuser(Long.valueOf(srt.boundValueOps(RedisPrefix.TODAY_NEW_USER).get()));
        dailyLog.setRound(Long.valueOf(srt.boundValueOps(RedisPrefix.TODAY_ROUND_ADD).get()));
        return dailyLog;
    }

    @Override
    //清空当日数据
    public void emptyToday() {
        srt.boundValueOps(RedisPrefix.TODAY_ARTICLE_ADD).set("0");
        srt.boundValueOps(RedisPrefix.TODAY_ARTICLE_READ).set("0");
        srt.boundValueOps(RedisPrefix.TODAY_NEW_USER).set("0");
        srt.boundValueOps(RedisPrefix.TODAY_ROUND_ADD).set("0");
        srt.opsForSet().pop(RedisPrefix.TODAY_LOGIN_USER, srt.boundSetOps(RedisPrefix.TODAY_LOGIN_USER).size());
    }


}
