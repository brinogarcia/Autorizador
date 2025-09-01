package com.autorizador.autorizador.port;

import java.math.BigDecimal;

public interface DataProviderAccount {

    void saveDebitoTransaction(String uuid, BigDecimal value, String currency, String status);

    void saveCreditoTransaction(String uuid, BigDecimal value, String currency, String status);
}
