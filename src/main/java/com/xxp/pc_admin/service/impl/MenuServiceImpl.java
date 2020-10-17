package com.xxp.pc_admin.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.xxp.pc_admin.dao.MenuMapper;
import com.xxp.pc_admin.domain.MenuExample;
import com.xxp.pc_admin.domain.Menu;
import com.xxp.pc_admin.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public long countByExample(MenuExample example) {
        return menuMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MenuExample example) {
        return menuMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public List<Menu> selectByExample(MenuExample example) {
        return menuMapper.selectByExample(example);
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Menu record, MenuExample example) {
        return menuMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Menu record, MenuExample example) {
        return menuMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.findByPid(0);
    }

}
