package com.xxp.pc_admin.controller;

import cn.hutool.core.util.StrUtil;
import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.domain.AdminUser;
import com.xxp.pc_admin.domain.Menu;
import com.xxp.pc_admin.domain.WebLog;
import com.xxp.pc_admin.service.MenuService;
import com.xxp.pc_admin.service.WebLogService;
import com.xxp.pc_admin.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

/**
 * @description: 菜单控制器
 * @author: xxp
 * @create: 2020-10-12 16:57
 */
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private WebLogService webLogService;
    @Autowired
    private SessionRegistry sessionRegistry;

    @GetMapping("/menus")
    public Result getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return Result.success(menus, "查找菜单成功");
    }

    @PostMapping("/doLogin")
    public Result doLogin(@RequestBody AdminUser adminUser, HttpServletRequest request) {
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        System.out.println("adminUser = " + adminUser);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(adminUser.getUsername(), adminUser.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AdminUser user = (AdminUser) authentication.getPrincipal();
        String s = jwtTokenUtil.generateToken(adminUser);
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        List<SessionInformation> allSessions = sessionRegistry.getAllSessions(allPrincipals, false);
        System.out.println("allPrincipals = " + allPrincipals.size());
        return Result.success(s, "登陆成功");
    }

    @PutMapping("/menu/edit")
    public Result editMenu(@RequestBody Menu menu) {
        if (menu.getPid() == 0 && StrUtil.isNotBlank(menu.getPath())) {
            return Result.fail("一级菜单不能添加地址!");
        }
        if (menu.getPid() != 0 && StrUtil.isBlank(menu.getPath())) {
            return Result.fail("二级菜单地址不能为空!");
        }
        menuService.updateByPrimaryKeySelective(menu);
        return Result.successWithNoData("修改成功!");
    }

    @PostMapping("/menu/add")
    public Result addMenu(@RequestBody Menu menu) {
        if (menu.getPid() == null) {
            menu.setPid(0);
        }
        if (menu.getPid() == 0 && StrUtil.isNotBlank(menu.getPath())) {
            return Result.fail("一级菜单不能添加地址!");
        }
        if (menu.getPid() != 0 && StrUtil.isBlank(menu.getPath())) {
            return Result.fail("二级菜单地址不能为空!");
        }
        menuService.insertSelective(menu);
        return Result.successWithNoData("添加成功!");
    }

    @DeleteMapping("/menu/delete/{id}")
    public Result deleteMenu(@PathVariable("id") Integer id) {
        menuService.deleteByPrimaryKey(id);
        return Result.successWithNoData("删除成功!");
    }

    @GetMapping("/log/list")
    public PageResult getLogList(
            @RequestParam("page") Integer page,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("username") String username) {
        return webLogService.getList(page, pageSize, username);
    }
}
