package com.autorizador.autorizador.adapter.out.sqs;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountListener {

    private String id;
    private String owner;
    private String created_at;
    private String status;

}
