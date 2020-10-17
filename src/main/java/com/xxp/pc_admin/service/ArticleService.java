package com.xxp.pc_admin.service;

import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.domain.Article;

import java.util.List;

import com.xxp.pc_admin.domain.ArticleExample;

public interface ArticleService {


    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Article record, ArticleExample example);

    int updateByExample(Article record, ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    PageResult getList(Integer page, Integer pageSize, String query, String creator, String tittle);
}
