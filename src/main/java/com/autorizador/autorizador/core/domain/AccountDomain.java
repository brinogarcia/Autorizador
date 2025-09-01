package com.autorizador.autorizador.core.domain;

import com.autorizador.autorizador.core.response.BalanceResponse;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AccountDomain {

    private String id;
    private BalanceDomain balance;
}
