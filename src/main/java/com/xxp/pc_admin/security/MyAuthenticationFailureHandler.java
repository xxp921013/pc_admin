package com.xxp.pc_admin.security;

import cn.hutool.json.JSONUtil;

import com.xxp.pc_admin.base.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录失败操作
 *
 * @author K. L. Mao
 * @create 2019/1/15
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        Result fail = Result.fail("登录失败");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(JSONUtil.toJsonStr(fail));
        writer.flush();
        writer.close();
    }
}
