package com.xxp.pc_admin.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xxp.pc_admin.domain.RoleExample;
import java.util.List;
import com.xxp.pc_admin.domain.Role;
import com.xxp.pc_admin.dao.RoleMapper;
import com.xxp.pc_admin.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public long countByExample(RoleExample example) {
        return roleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RoleExample example) {
        return roleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public List<Role> selectByExample(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Role record,RoleExample example) {
        return roleMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Role record,RoleExample example) {
        return roleMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }


}
