package com.autorizador.autorizador.adapter.handler.exception;

import com.autorizador.autorizador.adapter.handler.BusinessException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BusinessException {

    private static final long serialVersionUID = 1l;


    public NotFoundException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    public NotFoundException(HttpStatus errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
