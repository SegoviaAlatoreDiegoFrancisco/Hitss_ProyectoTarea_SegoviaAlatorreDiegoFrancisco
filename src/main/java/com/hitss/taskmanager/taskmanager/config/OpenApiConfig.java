package com.hitss.taskmanager.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI taskManagerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Manager API")
                        .description("API para gestión de tareas y usuarios del proyecto")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Diego Segovia")
                                .email("alatorresegovia@gmail.com")
                                .url("https://github.com/SegoviaAlatoreDiegoFrancisco"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio del Proyecto")
                        .url("https://github.com/SegoviaAlatoreDiegoFrancisco/Hitss_ProyectoTarea_SegoviaAlatorreDiegoFrancisco"));
    }
}