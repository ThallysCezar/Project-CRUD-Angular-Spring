package com.project.crudspring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
            new Info()
                .title("API de Cursos e Aulas")
                .version("1.0")
                .description("Uma API de demonstração para gerenciar cursos e suas respectivas aulas. "
                        + "Esta API oferece operações CRUD (Criar, Ler, Atualizar, Excluir) para cursos e aulas, "
                        + "armazenando os dados em um banco de dados PostgreSQL(com Docker). "
                        + "O código-fonte do projeto, incluindo o frontend e o backend, estão disponiveis no GitHub: "
                        + "https://github.com/ThallysCezar/Project-CRUD-Angular-Spring")
        );
    }
}
