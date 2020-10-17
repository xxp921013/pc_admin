package com.xxp.pc_admin.dao;

import com.xxp.pc_admin.domain.Article;
import com.xxp.pc_admin.domain.ArticleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> getList(@Param("likeDescription") String likeDescription, @Param("likeTittle") String likeTittle, @Param("likeCreator") String likeCreator);


}
