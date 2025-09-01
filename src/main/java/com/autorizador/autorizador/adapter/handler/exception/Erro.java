package com.autorizador.autorizador.adapter.handler.exception;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Erro {

    private String codigo;
    private String descricao;
    private String codigoHttp;

}
