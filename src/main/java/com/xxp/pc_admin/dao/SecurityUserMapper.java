package com.xxp.pc_admin.dao;

import com.xxp.pc_admin.domain.SecurityUser;
import com.xxp.pc_admin.domain.SecurityUserExample;

import java.util.List;

import com.xxp.pc_admin.dto.PCUserDTO;
import org.apache.ibatis.annotations.Param;

public interface SecurityUserMapper {
    long countByExample(SecurityUserExample example);

    int deleteByExample(SecurityUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    List<SecurityUser> selectByExample(SecurityUserExample example);

    SecurityUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecurityUser record, @Param("example") SecurityUserExample example);

    int updateByExample(@Param("record") SecurityUser record, @Param("example") SecurityUserExample example);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);

    List<PCUserDTO> findUserDTO(String query);




}
