package com.xxp.pc_admin.controller;

import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.domain.AdminUser;
import com.xxp.pc_admin.domain.Role;
import com.xxp.pc_admin.domain.RoleExample;
import com.xxp.pc_admin.service.AdminUserService;
import com.xxp.pc_admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * @description: 后台用户控制器
 * @author: xxp
 * @create: 2020-10-12 21:38
 */
@RestController
@RequestMapping("/admin/adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/list")
    public Result<List<AdminUser>> getList() {
        List<AdminUser> adminUsers = adminUserService.getList();
        return Result.success(adminUsers, "获取成功");
    }

    @PutMapping("/changeStatus/{id}/{status}")
    public Result changeStatus(@PathVariable("id") Integer id, @PathVariable("status") String status) {
        status = status.equals("1") ? "0" : "1";
        AdminUser adminUser = new AdminUser();
        adminUser.setId(id);
        adminUser.setStatus(status);
        adminUserService.updateByPrimaryKeySelective(adminUser);
        return Result.successWithNoData("修改成功!");
    }

    @GetMapping("/roles")
    public Result getRoles() {
        RoleExample roleExample = new RoleExample();
        roleExample.or().andNameIsNotNull();
        List<Role> roles = roleService.selectByExample(roleExample);
        return Result.success(roles, "查找成功!");
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody AdminUser adminUser) {
        AdminUser findUser = adminUserService.findByUsername(adminUser.getUsername());
        if (findUser != null) {
            return Result.fail("该用户名已存在!");
        }
        adminUser.setStatus("1");
        adminUser.setCreateTime(new Date());
        adminUser.setPassword(bCryptPasswordEncoder.encode(adminUser.getPassword()));
        adminUserService.insertSelective(adminUser);
        return Result.successWithNoData("添加成功!");
    }

    @PutMapping("/changeRole/{id}/{rid}")
    public Result changeRole(@PathVariable("id") Integer id, @PathVariable("rid") Integer rid) {
        AdminUser user = new AdminUser();
        user.setId(id);
        user.setRid(rid);
        adminUserService.updateByPrimaryKeySelective(user);
        return Result.successWithNoData("修改成功!");
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable("id") Integer id) {
        adminUserService.deleteByPrimaryKey(id);
        return Result.successWithNoData("删除成功!");
    }
}
