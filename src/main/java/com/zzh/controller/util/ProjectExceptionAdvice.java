package com.zzh.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R doOtherException(Exception ex){

        //记录日志
        //发消息给运维
        //发邮件给开发
        ex.printStackTrace();
        return new R(false,null,"系统异常，请稍后重试");
    }
}
