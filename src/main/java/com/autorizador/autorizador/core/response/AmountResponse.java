package com.autorizador.autorizador.core.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AmountResponse {

    private BigDecimal value;
    private String currency;
}
