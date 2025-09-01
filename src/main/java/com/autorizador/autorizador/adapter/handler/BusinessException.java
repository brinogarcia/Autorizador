package com.autorizador.autorizador.adapter.handler;


import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1l;
    private final String errorCode;
    private final String errorMsg;

    public BusinessException(Integer errorCode, String errorMsg, Throwable cause){
        super(errorMsg, cause);
        this.errorCode = Integer.toBinaryString(errorCode);
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg, Throwable cause){
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(Integer errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = Integer.toBinaryString(errorCode);
        this.errorMsg = errorMsg;
    }

    public BusinessException(HttpStatus errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = String.valueOf(errorCode.value());
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg(){ return errorMsg;}
    public String getErrorCode(){ return errorCode;}

}
