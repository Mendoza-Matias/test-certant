package com.mendozamatias.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration

@OpenAPIDefinition(
        info = @Info(
                title = "Gestión de consultorio médico - Mendoza Matias"
        )
)

@SecurityScheme(
        name = "basicAuth", // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class OpenApiConfig {
}
