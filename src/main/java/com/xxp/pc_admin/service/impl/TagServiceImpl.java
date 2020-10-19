package com.xxp.pc_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxp.pc_admin.base.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.xxp.pc_admin.domain.TagExample;
import com.xxp.pc_admin.domain.Tag;
import com.xxp.pc_admin.dao.TagMapper;
import com.xxp.pc_admin.service.TagService;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public long countByExample(TagExample example) {
        return tagMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TagExample example) {
        return tagMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tag record) {
        return tagMapper.insert(record);
    }

    @Override
    public int insertSelective(Tag record) {
        return tagMapper.insertSelective(record);
    }

    @Override
    public List<Tag> selectByExample(TagExample example) {
        return tagMapper.selectByExample(example);
    }

    @Override
    public Tag selectByPrimaryKey(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Tag record, TagExample example) {
        return tagMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Tag record, TagExample example) {
        return tagMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Tag record) {
        return tagMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tag record) {
        return tagMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult getList(Integer page, Integer pageSize, String query) {
        if (page == null || page == 0) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        List<Tag> allByNameLike = tagMapper.findAllByNameLike(query);
        PageInfo<Tag> tagPageInfo = new PageInfo<>(allByNameLike);
        return new PageResult("查找标签列表成功!", allByNameLike, 200, (int) tagPageInfo.getTotal());
    }

}
