package com.autorizador.autorizador.port;

import com.autorizador.autorizador.core.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizerRepository extends JpaRepository<AccountEntity, String> {

}
