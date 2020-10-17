package com.xxp.pc_admin.security;


import cn.hutool.json.JSONUtil;

import com.xxp.pc_admin.base.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 身份校验失败处理器，如 token 错误
 *
 * @author K. L. Mao
 * @create 2019/1/11
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        Result fail = Result.fail("认证失败");
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.toJsonStr(fail));
        writer.flush();
        writer.close();
    }
}
