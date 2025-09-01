package com.autorizador.autorizador.adapter.out.db;

import com.autorizador.autorizador.core.entities.TransactionEntity;
import com.autorizador.autorizador.port.AuthorizerRepository;
import com.autorizador.autorizador.port.DataProviderAccount;
import com.autorizador.autorizador.port.TransactionRepository;
import com.autorizador.autorizador.usecase.AutorizationCreditoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataProviderAccountImpl implements DataProviderAccount {
    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(DataProviderAccountImpl.class);
    private final TransactionRepository repository;
    private final AuthorizerRepository authorizerRepository;

    public DataProviderAccountImpl(TransactionRepository transactionRepository, AuthorizerRepository authorizerRepository){
        this.repository = transactionRepository;
        this.authorizerRepository = authorizerRepository;
    }


    @Override
    public void saveDebitoTransaction(String uuid, BigDecimal value, String currency, String status) {
        LOGGER_TECNICO.info("Salvando dados transação! ");
        TransactionEntity entity = new TransactionEntity();
        entity.setUuid(uuid);
        entity.setStatus(status);
        entity.setType("DEBITO");
        entity.setCurrency(currency);
        entity.setValue(value);

        repository.save(entity);

        LOGGER_TECNICO.info("Transação registrada !");
    }

    @Override
    public void saveCreditoTransaction(String uuid, BigDecimal value, String currency, String status) {
        LOGGER_TECNICO.info("Salvando dados transação!");
        TransactionEntity entity = new TransactionEntity();
        entity.setUuid(uuid);
        entity.setStatus(status);
        entity.setType("CREDITO");
        entity.setCurrency(currency);
        entity.setValue(value);

        repository.save(entity);

        LOGGER_TECNICO.info("Transação registrada !");

    }
}
