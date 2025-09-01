package com.autorizador.autorizador.core.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AmountRequest {

    private BigDecimal value;
    private String currency;
}
