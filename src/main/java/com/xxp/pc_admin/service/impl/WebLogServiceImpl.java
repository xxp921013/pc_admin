package com.xxp.pc_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxp.pc_admin.base.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.xxp.pc_admin.dao.WebLogMapper;

import java.util.List;

import com.xxp.pc_admin.domain.WebLog;
import com.xxp.pc_admin.domain.WebLogExample;
import com.xxp.pc_admin.service.WebLogService;

@Service
public class WebLogServiceImpl implements WebLogService {

    @Resource
    private WebLogMapper webLogMapper;

    @Override
    public long countByExample(WebLogExample example) {
        return webLogMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(WebLogExample example) {
        return webLogMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return webLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WebLog record) {
        return webLogMapper.insert(record);
    }

    @Override
    public int insertSelective(WebLog record) {
        return webLogMapper.insertSelective(record);
    }

    @Override
    public List<WebLog> selectByExample(WebLogExample example) {
        return webLogMapper.selectByExample(example);
    }

    @Override
    public WebLog selectByPrimaryKey(Integer id) {
        return webLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(WebLog record, WebLogExample example) {
        return webLogMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(WebLog record, WebLogExample example) {
        return webLogMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(WebLog record) {
        return webLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WebLog record) {
        return webLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult getList(Integer page, Integer pageSize, String username) {
        if (page == 0 || page == null) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        List<WebLog> webLogs = webLogMapper.selectAllByNameLike(username);
        PageInfo<WebLog> webLogPageInfo = new PageInfo<>(webLogs);
        return PageResult.success("查找成功", webLogs, (int) webLogPageInfo.getTotal());
    }

}


