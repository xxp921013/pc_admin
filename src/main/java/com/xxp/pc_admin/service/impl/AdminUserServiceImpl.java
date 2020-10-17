package com.xxp.pc_admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.xxp.pc_admin.dao.AdminUserMapper;

import java.util.ArrayList;
import java.util.List;

import com.xxp.pc_admin.domain.AdminUser;
import com.xxp.pc_admin.domain.AdminUserExample;
import com.xxp.pc_admin.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService, UserDetailsService {

    @Resource
    private AdminUserMapper adminUserMapper;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public long countByExample(AdminUserExample example) {
        return adminUserMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdminUserExample example) {
        return adminUserMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdminUser record) {
        return adminUserMapper.insert(record);
    }

    @Override
    public int insertSelective(AdminUser record) {
        return adminUserMapper.insertSelective(record);
    }

    @Override
    public List<AdminUser> selectByExample(AdminUserExample example) {
        return adminUserMapper.selectByExample(example);
    }

    @Override
    public AdminUser selectByPrimaryKey(Integer id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(AdminUser record, AdminUserExample example) {
        return adminUserMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(AdminUser record, AdminUserExample example) {
        return adminUserMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(AdminUser record) {
        return adminUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdminUser record) {
        return adminUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AdminUser> getList() {

        return adminUserMapper.getList();
    }

    @Override
    public AdminUser findByUsername(String username) {
        return adminUserMapper.findOneByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser oneByUsername = adminUserMapper.findOneByUsername(username);
        if (oneByUsername != null) {
            SimpleGrantedAuthority admin = null;
            if (oneByUsername.getRid() == 1) {
                admin = new SimpleGrantedAuthority("ADMIN");
            } else {
                admin = new SimpleGrantedAuthority("USER");
            }
            ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(admin);
            oneByUsername.setAuthorities(grantedAuthorities);
            return oneByUsername;
        }
        return null;
    }
}
