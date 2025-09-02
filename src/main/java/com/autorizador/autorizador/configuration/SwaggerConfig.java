package com.autorizador.autorizador.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Autorizador",
                version = "1.0",
                description = "Documentação de consumo da API de Autorização de transações",
                termsOfService = "Termos de serviço",
                contact = @Contact(
                        name = "Anderson",
                        email = "contato@exemplo.com",
                        url = "http://exemplo.com"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Servidor de Desenvolvimento")
        }
)
@Configuration
public class SwaggerConfig {
}
