package com.xxp.pc_admin.service;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.domain.Rounds;
import java.util.List;
import com.xxp.pc_admin.domain.RoundsExample;
public interface RoundsService{


    long countByExample(RoundsExample example);

    int deleteByExample(RoundsExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Rounds record);

    int insertSelective(Rounds record);

    List<Rounds> selectByExample(RoundsExample example);

    Rounds selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(Rounds record,RoundsExample example);

    int updateByExample(Rounds record,RoundsExample example);

    int updateByPrimaryKeySelective(Rounds record);

    int updateByPrimaryKey(Rounds record);

    PageResult getList(String creator, Integer articleId, Integer page, Integer pageSize);
}
