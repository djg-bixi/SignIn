package com.djg.signin.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandling {
    /**
     * 全局异常处理，反正异常返回统一格式的map
     * @Auhter DaiJianG
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> exceptionHandler(Exception ex){
        log.error("系统异常",ex);
        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("code","-1");
        map.put("success",false);
        map.put("message",ex.getMessage());
        return map;
     }
    }