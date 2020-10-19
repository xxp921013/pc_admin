package com.xxp.pc_admin.service;

import java.util.List;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.domain.TagExample;
import com.xxp.pc_admin.domain.Tag;
public interface TagService{


    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Tag record,TagExample example);

    int updateByExample(Tag record,TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    PageResult getList(Integer page, Integer pageSize, String query);
}
