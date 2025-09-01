package com.autorizador.autorizador.usecase.mapper;

import com.autorizador.autorizador.core.domain.AccountDomain;
import com.autorizador.autorizador.core.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapperUsecase {

    @Mapping(target = "balance.amount", source = "entity.amount")
    AccountDomain entityToDomain(AccountEntity entity);
}
