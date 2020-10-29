package com.xxp.pc_admin.dao;

import com.xxp.pc_admin.domain.HotArticle;
import com.xxp.pc_admin.domain.HotArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotArticleMapper {
    long countByExample(HotArticleExample example);

    int deleteByExample(HotArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(HotArticle record);

    int insertSelective(HotArticle record);

    List<HotArticle> selectByExample(HotArticleExample example);

    HotArticle selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(@Param("record") HotArticle record, @Param("example") HotArticleExample example);

    int updateByExample(@Param("record") HotArticle record, @Param("example") HotArticleExample example);

    int updateByPrimaryKeySelective(HotArticle record);

    int updateByPrimaryKey(HotArticle record);

    List<HotArticle> findAllByTittleLike(@Param("likeTittle")String likeTittle);



}
