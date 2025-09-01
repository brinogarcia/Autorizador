package com.autorizador.autorizador.core.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
public class BalanceDomain {
    private BigDecimal amount;
    private String currency;
}
