package com.xxp.pc_admin;

import com.xxp.pc_admin.dao.AdminUserMapper;
import com.xxp.pc_admin.dao.SecurityUserMapper;
import com.xxp.pc_admin.domain.AdminUser;
import com.xxp.pc_admin.dto.PCUserDTO;
import com.xxp.pc_admin.service.AdminUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;


@SpringBootTest
class PcAdminApplicationTest {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired
    private SecurityUserMapper securityUserMapper;

    @Test
    public void demo() {
        AdminUser adminUser = new AdminUser();
        adminUser.setCreateTime(new Date());
        adminUser.setPassword(bCryptPasswordEncoder.encode("123456"));
        adminUser.setRid(1);
        adminUser.setUsername("admin");
        adminUser.setStatus("1");
        adminUserService.insertSelective(adminUser);
    }

    @Test
    public void demo2() {
        AdminUser admin = adminUserMapper.findOneByUsername("admin");
        System.out.println("admin = " + admin);
    }

    @Test
    public void demo3() {
        List<PCUserDTO> userDTO = securityUserMapper.findUserDTO("23");
        userDTO.parallelStream().forEach(pcUserDTO -> pcUserDTO.setCreate(new Date(pcUserDTO.getGmtCreate())));
        System.out.println(userDTO);
    }
}
