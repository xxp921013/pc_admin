package com.xxp.pc_admin.controller;

import com.github.pagehelper.PageInfo;
import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.dto.PCUserDTO;
import com.xxp.pc_admin.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @description: 论坛用户控制器
 * @author: xxp
 * @create: 2020-10-14 16:17
 */
@RestController
@RequestMapping("/admin/pcUser")
public class PCUserController {
    @Autowired
    private SecurityUserService securityUserService;

    @GetMapping("/list")
    public PageResult getList(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam("query") String query) {
        System.out.println("query = " + query);
        List<PCUserDTO> dtos = securityUserService.findUserDTO(page, pageSize, query);
        dtos.parallelStream().forEach(pcUserDTO -> pcUserDTO.setCreate(new Date(pcUserDTO.getGmtCreate())));
        PageInfo<PCUserDTO> userDTOPageInfo = new PageInfo<>(dtos);
        return PageResult.success("查找成功!", dtos, (int) userDTOPageInfo.getTotal());
    }
}
