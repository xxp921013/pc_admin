package com.xxp.pc_admin.service;

import java.util.List;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.domain.HotArticleExample;
import com.xxp.pc_admin.domain.HotArticle;
public interface HotArticleService{


    long countByExample(HotArticleExample example);

    int deleteByExample(HotArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(HotArticle record);

    int insertSelective(HotArticle record);

    List<HotArticle> selectByExample(HotArticleExample example);

    HotArticle selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(HotArticle record,HotArticleExample example);

    int updateByExample(HotArticle record,HotArticleExample example);

    int updateByPrimaryKeySelective(HotArticle record);

    int updateByPrimaryKey(HotArticle record);

    PageResult getList(Integer page, Integer pageSize, String query);
}
