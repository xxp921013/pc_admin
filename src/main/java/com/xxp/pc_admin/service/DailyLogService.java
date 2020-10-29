package com.xxp.pc_admin.service;

import java.util.List;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.domain.DailyLogExample;
import com.xxp.pc_admin.domain.DailyLog;
public interface DailyLogService{


    long countByExample(DailyLogExample example);

    int deleteByExample(DailyLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DailyLog record);

    int insertSelective(DailyLog record);

    List<DailyLog> selectByExample(DailyLogExample example);

    DailyLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(DailyLog record,DailyLogExample example);

    int updateByExample(DailyLog record,DailyLogExample example);

    int updateByPrimaryKeySelective(DailyLog record);

    int updateByPrimaryKey(DailyLog record);


    PageResult getList(Integer page, Integer pageSize);

    DailyLog getDaily();

    void emptyToday();
}
