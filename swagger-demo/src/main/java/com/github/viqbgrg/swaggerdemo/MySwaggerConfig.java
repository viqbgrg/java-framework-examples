package com.github.viqbgrg.swaggerdemo;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
public class MySwaggerConfig {


    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
//                .additionalModels(typeResolver.resolve(ResponseEntity.class))
                .produces(new HashSet<>(
                        Arrays.asList(
                                "application/json")))
//                .alternateTypeRules(newRule(
//                        LocalDate.class,
//                        String.class))
                .select()
//                .paths(PathSelectors.regex(".*/features/.*"))
                .build();
//        HashSet<String> medisType = new HashSet<>(Arrays.asList("application/json"));
//        return new Docket(DocumentationType.OAS_30)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .pathMapping("/")
//                .directModelSubstitute(LocalDate.class, String.class)
////                .genericModelSubstitutes(ResponseEntity.class)
////                .alternateTypeRules(
////                        newRule(typeResolver.resolve(DeferredResult.class,
////                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
////                                typeResolver.resolve(WildcardType.class)))
//                .useDefaultResponseMessages(false)
//                .produces(medisType)
//                .consumes(medisType);
    }









    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .showCommonExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }
}
