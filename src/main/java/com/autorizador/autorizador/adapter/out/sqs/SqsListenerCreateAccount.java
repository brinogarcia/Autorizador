package com.autorizador.autorizador.adapter.out.sqs;

import com.autorizador.autorizador.adapter.out.mapper.AccountMapper;
import com.autorizador.autorizador.port.AuthorizerRepository;
import com.autorizador.autorizador.usecase.AutorizationDebitoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SqsListenerCreateAccount {

    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(SqsListenerCreateAccount.class);
    private final AuthorizerRepository authorizerRepository;
    private final AccountMapper mapper;

    public  SqsListenerCreateAccount(AuthorizerRepository authorizerRepository,
                                     AccountMapper mapper){
        this.authorizerRepository = authorizerRepository;
        this.mapper = mapper;
    }

    @SqsListener(value = "conta-bancaria-criada")
    public void receiveMessage(String queueDTO) {
        Gson gson = new Gson();
        JsonObject message = gson.fromJson(queueDTO, JsonObject.class);
        AccountListener account = gson.fromJson(message.get("account"), AccountListener.class);
        LOGGER_TECNICO.info("Recebendo a mensagem da fila: {}", account.getId());

        authorizerRepository.save(mapper.listenerToEntity(account, new BigDecimal(0)));
        LOGGER_TECNICO.info("Conta salva na base!");
    }


}
