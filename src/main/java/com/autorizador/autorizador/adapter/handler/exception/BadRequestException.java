package com.autorizador.autorizador.adapter.handler.exception;

import com.autorizador.autorizador.adapter.handler.BusinessException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BusinessException {

    private static final long serialVersionUID = 3l;


    public BadRequestException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    public BadRequestException(HttpStatus errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}