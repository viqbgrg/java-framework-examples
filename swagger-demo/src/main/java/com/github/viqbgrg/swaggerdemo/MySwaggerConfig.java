package com.github.viqbgrg.swaggerdemo;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.Example;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author hhj
 */
@Configuration
public class MySwaggerConfig {


    private final TypeResolver typeResolver;

    public MySwaggerConfig(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Bean
    public Docket petApi() {

        HashSet<String> mediaType = new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        return new Docket(DocumentationType.OAS_30)
                .directModelSubstitute(LocalDate.class, String.class)
                .useDefaultResponseMessages(false)
//                .genericModelSubstitutes(ResponseEntity.class)
                // 可以直接显示包装里面的实体类
                .genericModelSubstitutes(Result.class)
//                .additionalModels(typeResolver.resolve(ResponseEntity.class))
                .select().apis(RequestHandlerSelectors.any()).build()
                .produces(mediaType)
                .consumes(mediaType)
//                .globalResponses(HttpMethod.POST,
//                        singletonList(new ResponseBuilder()
//                                .code("200")
//                                .description("500 message")
//                                .representation(MediaType.TEXT_XML)
//                                .apply(r ->
//                                        r.model(m ->
//                                                m.referenceModel(ref ->
//                                                        ref.key(k ->
//                                                                k.qualifiedModelName(q ->
//                                                                        q.namespace("some:namespace")
//                                                                                .name("ERROR"))))))
//                                .build()))
//                .globalRequestParameters(paramConfig())
                ;
    }


    private List<RequestParameter> paramConfig() {
        ArrayList<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder().name("token").in(ParameterType.HEADER)
                .description("用户的token")
                .required(true).build());
        return parameters;
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
