package org.sc.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class LogAdvice {


    /***
     * 切入点
     */
    @Pointcut("execution(* org.sc.service.impl.UserServiceImpl.*(..))")
    public void saveLog(){

    }

    @Before(value = "execution(* org.sc.service.impl.UserServiceImpl.*(..))")
    public void save1(){
        System.out.println("执行了");
    }

    @After(value = "saveLog()")
    public void saveQueryLog(JoinPoint joinPoint){
        System.out.println("查询日志：" + joinPoint.getArgs().toString());
    }

}
