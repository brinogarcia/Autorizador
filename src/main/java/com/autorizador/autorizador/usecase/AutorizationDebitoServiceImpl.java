package com.autorizador.autorizador.usecase;

import com.autorizador.autorizador.adapter.handler.exception.NotFoundException;
import com.autorizador.autorizador.adapter.handler.exception.UnprocessableEntity;
import com.autorizador.autorizador.core.domain.AccountDomain;
import com.autorizador.autorizador.core.entities.AccountEntity;
import com.autorizador.autorizador.core.request.TransactionRequest;
import com.autorizador.autorizador.core.response.*;
import com.autorizador.autorizador.port.AuthorizerRepository;
import com.autorizador.autorizador.port.AutorizationDebitoService;
import com.autorizador.autorizador.port.DataProviderAccount;
import com.autorizador.autorizador.usecase.mapper.AccountMapperUsecase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorizationDebitoServiceImpl implements AutorizationDebitoService {
    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(AutorizationDebitoServiceImpl.class);
    private final AuthorizerRepository repository;
    private final AccountMapperUsecase mapper;
    private final DataProviderAccount dataProviderAccount;

    public AutorizationDebitoServiceImpl(AuthorizerRepository repository,
                                         AccountMapperUsecase mapper,
                                         DataProviderAccount dataProviderAccount){
        this.repository = repository;
        this.mapper = mapper;
        this.dataProviderAccount = dataProviderAccount;
    }
    @Override
    public AutorizationResponse autorization(TransactionRequest transactionRequest, String transactionId) {
        AutorizationResponse response = new AutorizationResponse();
        TransactionResponse transactionResponse = new TransactionResponse();
        AccountResponse accountResponse = new AccountResponse();
        AmountResponse amountResponse = new AmountResponse();
        BalanceResponse balanceResponse = new BalanceResponse();


        UUID uuidTransacao = UUID.randomUUID();
        LOGGER_TECNICO.info("UUID da transação : " + uuidTransacao);


        BigDecimal totatlAmount = new BigDecimal(0);
        //validar existencia da conta

        Optional<AccountEntity> entity = repository.findById(transactionRequest.getAccountId());
        if(entity.isPresent()) {
            LOGGER_TECNICO.info("Conta encontrada, seguindo transação de débito!");
            AccountDomain accountDomain = mapper.entityToDomain(repository.findById(transactionRequest.getAccountId()).get());

            totatlAmount = accountDomain.getBalance().getAmount().subtract(transactionRequest.getAmount().getValue());

            if (totatlAmount.compareTo(new BigDecimal(0)) > 0) {
                LOGGER_TECNICO.info("Conta com saldo disponível!");
                entity.get().setAmount(totatlAmount);
                repository.save(entity.get());
                dataProviderAccount.saveDebitoTransaction(String.valueOf(uuidTransacao), transactionRequest.getAmount().getValue(),transactionRequest.getAmount().getCurrency(), "sucess");

            }else{
                LOGGER_TECNICO.info("Conta sem saldo suficiente!");
                throw new UnprocessableEntity(HttpStatus.UNPROCESSABLE_ENTITY, "Conta não possuí saldo sulficiente!");
            }

            transactionResponse.setAmount(amountResponse);
            transactionResponse.setId(transactionId);

            amountResponse.setCurrency(transactionRequest.getAmount().getCurrency());
            amountResponse.setValue(transactionRequest.getAmount().getValue());
            balanceResponse.setAmount(totatlAmount);
            balanceResponse.setCurrency(transactionRequest.getAmount().getCurrency());
            accountResponse.setId(entity.get().getId());
            accountResponse.setBalance(balanceResponse);
            response.setAccount(accountResponse);
            response.setTransaction(transactionResponse);
            return response;

        }else {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "Conta não encontrada ou não existe");

        }
    }
}
