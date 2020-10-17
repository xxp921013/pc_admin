package com.xxp.pc_admin.service;

import java.util.List;

import com.xxp.pc_admin.domain.AdminUser;
import com.xxp.pc_admin.domain.AdminUserExample;

public interface AdminUserService {


    long countByExample(AdminUserExample example);

    int deleteByExample(AdminUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    List<AdminUser> selectByExample(AdminUserExample example);

    AdminUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(AdminUser record, AdminUserExample example);

    int updateByExample(AdminUser record, AdminUserExample example);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    List<AdminUser> getList();

    AdminUser findByUsername(String username);
}
