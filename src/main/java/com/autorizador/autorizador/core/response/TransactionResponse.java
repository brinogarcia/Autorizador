package com.autorizador.autorizador.core.response;

import lombok.*;

import java.security.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionResponse {

    private String id;
    private String type;
    private AmountResponse amount;
    private String status;
    private Timestamp timestamp;

}
