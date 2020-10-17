package com.xxp.pc_admin.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 分页结果
 * @author: xxp
 * @create: 2020-10-12 17:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult extends Result {
    private Integer page;
    private Integer total;

    public PageResult(String message, Object data, Integer code, Integer total) {
        super(message, data, code);
        this.total = total;
    }

    public static PageResult success(String message, Object data, Integer total) {
        return new PageResult(message, data, 200, total);
    }
}
