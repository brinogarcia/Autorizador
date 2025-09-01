package com.autorizador.autorizador.adapter.handler.exception;

import com.autorizador.autorizador.adapter.handler.BusinessException;
import org.springframework.http.HttpStatus;

public class UnprocessableEntity extends BusinessException {

    private static final long serialVersionUID = 2l;


    public UnprocessableEntity(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    public UnprocessableEntity(HttpStatus errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
