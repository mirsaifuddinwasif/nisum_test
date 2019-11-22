package com.nisum.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nisum"))
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Persona Info - Spring Boot Application")
                .description("Nisum Test Spring Boot Api Documentation")
                .termsOfServiceUrl("TERMS OF SERVICE URL")
                .license("MIT License")
                .licenseUrl("LICENSE URL")
                .version("1.0")
                .contact(new Contact("nisum-test-persona-info-spring-boot-app", "www.nisum-test.com", "mirsaifuddinwasif@gmail.com"))
                .build();
    }
}
