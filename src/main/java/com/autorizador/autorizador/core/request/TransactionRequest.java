package com.autorizador.autorizador.core.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionRequest {

    private String accountId;
    private String type;
    private AmountRequest amount;


}
