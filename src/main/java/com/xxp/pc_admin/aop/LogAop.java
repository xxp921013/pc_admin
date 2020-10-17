package com.xxp.pc_admin.aop;

import cn.hutool.core.date.DateUtil;
import com.xxp.pc_admin.base.Result;
import com.xxp.pc_admin.domain.AdminUser;
import com.xxp.pc_admin.domain.WebLog;
import com.xxp.pc_admin.service.WebLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Slf4j
@Component
public class LogAop {
    @Autowired
    private WebLogService webLogService;

    @Pointcut("execution(* com.xxp.pc_admin.controller.*.*(..))")
    public void logPointcut() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAop.class);

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        long startTime = DateUtil.current(false);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        WebLog webLog = new WebLog();
        Object proceed = joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        String desc = method.getName();
        if ("getLogList".equals(desc)) {
            return proceed;
        }
        long endTime = System.currentTimeMillis();
//        stopWatch.stop();
//        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String ip = request.getRemoteHost();

        webLog.setDescription(desc);
        webLog.setIp(ip);
        webLog.setSpendTime(endTime - startTime);
        webLog.setStartTime(new Date());
        webLog.setUri(uri);
        webLog.setUrl(url);
        Result result = (Result) proceed;
        webLog.setCode(result.getCode());
        webLog.setMessage(result.getMessage());
        AdminUser user = (AdminUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        webLog.setName(user.getUsername());
        webLogService.insertSelective(webLog);
        return proceed;
    }
}
