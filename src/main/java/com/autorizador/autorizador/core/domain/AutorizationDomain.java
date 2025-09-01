package com.autorizador.autorizador.core.domain;

import com.autorizador.autorizador.core.response.TransactionResponse;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AutorizationDomain {

    private TransactionResponse transaction;
    private AccountDomain account;
}
