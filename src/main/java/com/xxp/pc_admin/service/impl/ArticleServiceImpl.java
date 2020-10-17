package com.xxp.pc_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxp.pc_admin.base.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.xxp.pc_admin.domain.Article;

import java.util.List;

import com.xxp.pc_admin.domain.ArticleExample;
import com.xxp.pc_admin.dao.ArticleMapper;
import com.xxp.pc_admin.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public long countByExample(ArticleExample example) {
        return articleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleExample example) {
        return articleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Article record) {
        return articleMapper.insert(record);
    }

    @Override
    public int insertSelective(Article record) {
        return articleMapper.insertSelective(record);
    }

    @Override
    public List<Article> selectByExample(ArticleExample example) {
        return articleMapper.selectByExample(example);
    }

    @Override
    public Article selectByPrimaryKey(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Article record, ArticleExample example) {
        return articleMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Article record, ArticleExample example) {
        return articleMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return articleMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult getList(Integer page, Integer pageSize, String query, String creator, String tittle) {
        if (page == 0 || page == null) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        List<Article> articles = articleMapper.getList(query, tittle, creator);
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);
        return PageResult.success("查找文章成功!", articles, (int) articlePageInfo.getTotal());
    }

}
