package dev.aniele.apifilmes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiFilmes () {
        return new OpenAPI().info(new Info().title("API Filmes").version("2.0").description("API de aprendizado acadêmico").license(new License().name("Aniele DEV").url("https://github.com/AnielePA")) );
    }

}
