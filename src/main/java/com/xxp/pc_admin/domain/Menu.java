package com.xxp.pc_admin.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 后台菜单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    private Integer id;

    /**
     * 菜单名称
     */
    private String authName;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 地址
     */
    private String path;

    private List<Menu> children;

    private static final long serialVersionUID = 1L;

}
