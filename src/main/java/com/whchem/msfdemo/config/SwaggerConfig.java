package com.whchem.msfdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo initApiInfo() {
        return new ApiInfoBuilder().title("msf-demo API")
                .description(initContextInfo())
                .termsOfServiceUrl("")
                .contact(new Contact("", "", ""))
                .version("1.0.0")
                .build();
    }

    private String initContextInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("REST API 设计在细节上有很多自己独特的需要注意的技巧，并且对开发人员在构架设计能力上比传统 API 有着更高的要求。").append("<br/>")
                .append("以下是本项目的API文档");
        return sb.toString();
    }

    @Bean
    public Docket restfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // .groupName("RestfulApi")
                .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(true).forCodeGeneration(true)
                .pathMapping("/") // base，最终调用接口后会和paths拼接在一起
                .select().apis(RequestHandlerSelectors.basePackage("com.whchem.msfdemo.controller"))
                .paths(PathSelectors.any()).build().apiInfo(initApiInfo());

    }
}
