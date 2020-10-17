package com.xxp.pc_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxp.pc_admin.dto.PCUserDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.xxp.pc_admin.domain.SecurityUserExample;

import java.util.List;

import com.xxp.pc_admin.domain.SecurityUser;
import com.xxp.pc_admin.dao.SecurityUserMapper;
import com.xxp.pc_admin.service.SecurityUserService;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {

    @Resource
    private SecurityUserMapper securityUserMapper;

    @Override
    public long countByExample(SecurityUserExample example) {
        return securityUserMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SecurityUserExample example) {
        return securityUserMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return securityUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SecurityUser record) {
        return securityUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SecurityUser record) {
        return securityUserMapper.insertSelective(record);
    }

    @Override
    public List<SecurityUser> selectByExample(SecurityUserExample example) {
        return securityUserMapper.selectByExample(example);
    }

    @Override
    public SecurityUser selectByPrimaryKey(Integer id) {
        return securityUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SecurityUser record, SecurityUserExample example) {
        return securityUserMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SecurityUser record, SecurityUserExample example) {
        return securityUserMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SecurityUser record) {
        return securityUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SecurityUser record) {
        return securityUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PCUserDTO> findUserDTO(Integer page, Integer pageSize, String query) {
        if (page == 0 || page == null) {
            page = 1;
        }
        PageHelper.startPage(page, pageSize);
        return securityUserMapper.findUserDTO(query);

    }

}
