package com.autorizador.autorizador.core.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
public class BalanceResponse {

    private BigDecimal amount;
    private String currency;
}
