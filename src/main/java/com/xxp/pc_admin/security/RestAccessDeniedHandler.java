package com.xxp.pc_admin.security;


import cn.hutool.json.JSONUtil;
import com.xxp.pc_admin.base.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限校验处理器
 *
 * @author K. L. Mao
 * @create 2019/1/11
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        Result fail = Result.fail("没有权限");
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.toJsonStr(fail));
        writer.flush();
        writer.close();
    }
}
