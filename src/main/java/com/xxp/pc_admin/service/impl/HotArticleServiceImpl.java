package com.xxp.pc_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxp.pc_admin.base.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.xxp.pc_admin.domain.HotArticleExample;
import com.xxp.pc_admin.domain.HotArticle;
import com.xxp.pc_admin.dao.HotArticleMapper;
import com.xxp.pc_admin.service.HotArticleService;

@Service
public class HotArticleServiceImpl implements HotArticleService {

    @Resource
    private HotArticleMapper hotArticleMapper;

    @Override
    public long countByExample(HotArticleExample example) {
        return hotArticleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(HotArticleExample example) {
        return hotArticleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer articleId) {
        return hotArticleMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public int insert(HotArticle record) {
        return hotArticleMapper.insert(record);
    }

    @Override
    public int insertSelective(HotArticle record) {
        return hotArticleMapper.insertSelective(record);
    }

    @Override
    public List<HotArticle> selectByExample(HotArticleExample example) {
        return hotArticleMapper.selectByExample(example);
    }

    @Override
    public HotArticle selectByPrimaryKey(Integer articleId) {
        return hotArticleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public int updateByExampleSelective(HotArticle record, HotArticleExample example) {
        return hotArticleMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(HotArticle record, HotArticleExample example) {
        return hotArticleMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(HotArticle record) {
        return hotArticleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HotArticle record) {
        return hotArticleMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult getList(Integer page, Integer pageSize, String query) {
        if (page == null || page == 0) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        List<HotArticle> allByTittleLike = hotArticleMapper.findAllByTittleLike(query);
        PageInfo<HotArticle> hotArticlePageInfo = new PageInfo<>(allByTittleLike);
        return PageResult.success("查找成功!", allByTittleLike, (int) hotArticlePageInfo.getTotal());
    }

}
