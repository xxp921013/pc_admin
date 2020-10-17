package com.xxp.pc_admin.service;

import java.util.List;
import com.xxp.pc_admin.domain.MenuExample;
import com.xxp.pc_admin.domain.Menu;
public interface MenuService{


    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Menu record,MenuExample example);

    int updateByExample(Menu record,MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAllMenus();
}
