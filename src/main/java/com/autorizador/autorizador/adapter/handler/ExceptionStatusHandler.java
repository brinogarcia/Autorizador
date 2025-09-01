package com.autorizador.autorizador.adapter.handler;

import com.autorizador.autorizador.adapter.handler.exception.BadRequestException;
import com.autorizador.autorizador.adapter.handler.exception.Erro;
import com.autorizador.autorizador.adapter.handler.exception.NotFoundException;
import com.autorizador.autorizador.adapter.handler.exception.UnprocessableEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionStatusHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Erro> erroNotFoundExceptionHandler(NotFoundException e){
        Erro erro = new Erro();
        erro.setCodigo("NTF-01");
        erro.setDescricao(e.getErrorMsg());
        erro.setCodigoHttp(e.getErrorCode());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Erro> erroBadRequestExceptionHandler(BadRequestException e){
        Erro erro = new Erro();
        erro.setCodigo("BR-01");
        erro.setDescricao(e.getErrorMsg());
        erro.setCodigoHttp(e.getErrorCode());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {UnprocessableEntity.class})
    public ResponseEntity<Erro> erroUnprocessableEntityHandler(UnprocessableEntity e){
        Erro erro = new Erro();
        erro.setCodigo("UE-01");
        erro.setDescricao(e.getErrorMsg());
        erro.setCodigoHttp(e.getErrorCode());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
}
