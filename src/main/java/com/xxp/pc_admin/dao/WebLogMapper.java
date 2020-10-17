package com.xxp.pc_admin.dao;

import com.xxp.pc_admin.domain.WebLog;
import com.xxp.pc_admin.domain.WebLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebLogMapper {
    long countByExample(WebLogExample example);

    int deleteByExample(WebLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebLog record);

    int insertSelective(WebLog record);

    List<WebLog> selectByExample(WebLogExample example);

    WebLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebLog record, @Param("example") WebLogExample example);

    int updateByExample(@Param("record") WebLog record, @Param("example") WebLogExample example);

    int updateByPrimaryKeySelective(WebLog record);

    int updateByPrimaryKey(WebLog record);

    List<WebLog> selectAllByNameLike(@Param("likeName")String likeName);


}
