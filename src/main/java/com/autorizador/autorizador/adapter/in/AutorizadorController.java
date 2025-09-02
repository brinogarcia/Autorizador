package com.autorizador.autorizador.adapter.in;

import com.autorizador.autorizador.adapter.handler.exception.BadRequestException;
import com.autorizador.autorizador.core.request.TransactionRequest;
import com.autorizador.autorizador.core.response.AutorizationResponse;
import com.autorizador.autorizador.port.AutorizationCreditoService;
import com.autorizador.autorizador.port.AutorizationDebitoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class AutorizadorController {

    private final AutorizationDebitoService debitoService;
    private final AutorizationCreditoService creditoServiceservice;

    public AutorizadorController(AutorizationDebitoService debitoService,
                                 AutorizationCreditoService creditoServiceservice){
        this.debitoService = debitoService;
        this.creditoServiceservice = creditoServiceservice;

    }

    @Operation(summary = "Executar transação", description = "Executa transação de acordo com o Tipo CREDITO ou DEBITO, validando as informações da conta!")
    @PostMapping("/{transactionId}")
    public ResponseEntity<AutorizationResponse> autorization(@RequestBody TransactionRequest transactionRequest, @PathVariable String transactionId){
        switch (transactionRequest.getType()){
            case "CREDITO":
                return ResponseEntity.ok(creditoServiceservice.autorization(transactionRequest, transactionId));
            case "DEBITO":
                return ResponseEntity.ok(debitoService.autorization(transactionRequest, transactionId));
            default:
                throw new BadRequestException(HttpStatus.BAD_REQUEST, "O campo 'Type' deve conter os valores 'DEBITO' ou 'CREDITO' ");
        }

    }
}
