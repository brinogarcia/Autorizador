package com.autorizador.autorizador.core.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AutorizationResponse {

    private TransactionResponse transaction;
    private AccountResponse account;
}
