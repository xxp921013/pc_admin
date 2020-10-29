package com.xxp.pc_admin.dao;

import com.xxp.pc_admin.domain.DailyLog;
import com.xxp.pc_admin.domain.DailyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyLogMapper {
    long countByExample(DailyLogExample example);

    int deleteByExample(DailyLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DailyLog record);

    int insertSelective(DailyLog record);

    List<DailyLog> selectByExample(DailyLogExample example);

    DailyLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DailyLog record, @Param("example") DailyLogExample example);

    int updateByExample(@Param("record") DailyLog record, @Param("example") DailyLogExample example);

    int updateByPrimaryKeySelective(DailyLog record);

    int updateByPrimaryKey(DailyLog record);
}