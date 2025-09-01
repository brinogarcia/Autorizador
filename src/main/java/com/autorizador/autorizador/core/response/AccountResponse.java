package com.autorizador.autorizador.core.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AccountResponse {

    private String id;
    private BalanceResponse balance;
}
