package com.xxp.pc_admin.service;

import com.xxp.pc_admin.domain.SecurityUserExample;
import java.util.List;
import com.xxp.pc_admin.domain.SecurityUser;
import com.xxp.pc_admin.dto.PCUserDTO;

public interface SecurityUserService{


    long countByExample(SecurityUserExample example);

    int deleteByExample(SecurityUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    List<SecurityUser> selectByExample(SecurityUserExample example);

    SecurityUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(SecurityUser record,SecurityUserExample example);

    int updateByExample(SecurityUser record,SecurityUserExample example);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);

    List<PCUserDTO> findUserDTO(Integer page, Integer pageSize, String query);
}
