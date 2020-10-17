package com.xxp.pc_admin.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 通用返回结果
 * @author: xxp
 * @create: 2020-10-12 16:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private String message;
    private T data;
    private Integer code;

    public Result(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public static Result success(Object data, String message) {
        return new Result(message, data, 200);
    }

    public static Result successWithNoData(String message) {
        return new Result(message, 200);
    }

    public static Result fail(String message) {
        return new Result(message, 500);
    }
}
