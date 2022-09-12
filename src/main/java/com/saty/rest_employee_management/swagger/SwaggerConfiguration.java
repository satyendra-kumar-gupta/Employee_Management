package com.saty.rest_employee_management.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    public static final Contact SUPPORT_CONTACTS = new Contact("saty","http://www.saty.com",
            "saty@gmail.com");

    @Bean
    public Docket newApi(){
        Set produce = new HashSet<>(Arrays.asList("application/json","application/xml"));
        Set consume = new HashSet<>(Arrays.asList("application/json","application/xml"));
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(produce)
                .consumes(consume);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Service")
                .description("Employee Service With Swagger Documentation")
                .termsOfServiceUrl("http://www.saty.com?ect")
                .contact(SUPPORT_CONTACTS)
                .license("Employee licence Version 1.0")
                .licenseUrl("http://www.saty.com?ect")
                .version("1.0")
                .build();
    }
}











































