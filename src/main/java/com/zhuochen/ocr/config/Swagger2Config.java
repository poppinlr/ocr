package com.zhuochen.ocr.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhuochen on 2017/7/10.
 */
@EnableSwagger2
@Configuration
@Log4j2
public class Swagger2Config {

    @Autowired
    private RestTemplate restTemplate;
    //
    @Autowired
    private Environment environment;

    //
    //swagger-ui.html
    ///v2/api-docs
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhuochen.ocr.controller"))
                .paths(PathSelectors.any())
                .build();

//        if (Lists.newArrayList(environment.getActiveProfiles()).contains("dev")) {
//            ParameterBuilder tokenPar = new ParameterBuilder();
//            List<Parameter> pars = new ArrayList<>();
//
//            tokenPar.name("x-um-user-token")
//                    .description("令牌")
//                    .parameterType("header")
//                    .modelRef(new ModelRef("string"))
//                    .defaultValue(this.login())
//                    .required(false).build();
//            pars.add(tokenPar.build());
//
//            return docket.globalOperationParameters(pars);
//        } else {
//            return docket;
//        }

        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BASH API list")
                .description("")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("1.0")
                .build();
    }

//    private String login() {
//        Map<String, String> login = new HashMap<>();
//        login.put("username", "guanli1");
//        login.put("password", "aA123456789");
//        Map<String, String> response = restTemplate.exchange("http://bash-dev.leapstack.cn/gw/um/login", HttpMethod.POST,  new HttpEntity<>(login), new ParameterizedTypeReference<Map<String, String>>() {}).getBody();
//        log.info(response);
//        return response.get("data");
//    }
}