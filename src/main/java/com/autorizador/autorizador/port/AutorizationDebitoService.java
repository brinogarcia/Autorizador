package com.autorizador.autorizador.port;

import com.autorizador.autorizador.core.request.TransactionRequest;
import com.autorizador.autorizador.core.response.AutorizationResponse;

public interface AutorizationDebitoService {

        AutorizationResponse autorization(TransactionRequest transactionRequest, String transactionId);

}
