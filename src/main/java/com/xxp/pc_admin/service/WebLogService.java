package com.xxp.pc_admin.service;

import java.util.List;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.domain.WebLog;
import com.xxp.pc_admin.domain.WebLogExample;

public interface WebLogService {


    long countByExample(WebLogExample example);

    int deleteByExample(WebLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebLog record);

    int insertSelective(WebLog record);

    List<WebLog> selectByExample(WebLogExample example);

    WebLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(WebLog record, WebLogExample example);

    int updateByExample(WebLog record, WebLogExample example);

    int updateByPrimaryKeySelective(WebLog record);

    int updateByPrimaryKey(WebLog record);

    PageResult getList(Integer page, Integer pageSize, String username);
}


