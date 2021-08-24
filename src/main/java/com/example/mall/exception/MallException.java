package com.example.mall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 理统一异常的handler
 */

public class MallException extends  RuntimeException{
    private final Integer code;
    private final String message;

    public MallException(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public MallException(MallExceptionEnum exceptionEnum){
        this(exceptionEnum.getCode(),exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
