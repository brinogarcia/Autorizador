package com.autorizador.autorizador.adapter.out.mapper;

import com.autorizador.autorizador.adapter.out.sqs.AccountListener;
import com.autorizador.autorizador.core.domain.AccountDomain;
import com.autorizador.autorizador.core.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "amount", source = "amount")
    AccountEntity listenerToEntity(AccountListener listener, BigDecimal amount);

}
