package com.demigod.tutorial.swaggerConfig;

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

import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.demigod.tutorial.controller"))
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(metaData())
                .protocols(new HashSet<>(Collections.singletonList("http")));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Rest Service for My Project")
                .description("Rest Service for Technical Charts using Spring Boot")
                .termsOfServiceUrl("Terms of Service").license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE").version("2.0")
                .contact(new Contact("Tejas Salvi", "url", "tejasnsalvi@gmail.com")).build();
    }
}
