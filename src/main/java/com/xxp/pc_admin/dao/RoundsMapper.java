package com.xxp.pc_admin.dao;

import com.xxp.pc_admin.domain.Rounds;
import com.xxp.pc_admin.domain.RoundsExample;

import java.util.List;

import com.xxp.pc_admin.dto.RoundDTO;
import org.apache.ibatis.annotations.Param;

public interface RoundsMapper {
    long countByExample(RoundsExample example);

    int deleteByExample(RoundsExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Rounds record);

    int insertSelective(Rounds record);

    List<Rounds> selectByExample(RoundsExample example);

    Rounds selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Rounds record, @Param("example") RoundsExample example);

    int updateByExample(@Param("record") Rounds record, @Param("example") RoundsExample example);

    int updateByPrimaryKeySelective(Rounds record);

    int updateByPrimaryKey(Rounds record);

    List<RoundDTO> getList(@Param("creator") String creator, @Param("articleId") Integer articleId);
}
