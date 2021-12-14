package basico.springboot.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;

import io.swagger.annotations.AuthorizationScope;
import io.swagger.annotations.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                    .useDefaultResponseMessages(false)
                    .select()
                    .apis(RequestHandlerSelectors
                        .basePackage("basico.springboot.api.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .securityContexts(Arrays.asList(securityContext()))
                    .securityContext(Arrays.asList(apiKey()))
                    .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                    .title("VENDAS API")
                    .description("Projeto Vendas")
                    .version("1.0")
                    .contact(contact)
                    .build();
    }

    private Contact contact(){
        return new Contact(
            "Lucas Alexandre", 
            "http://meusite.com",
            "teste@teste"
        );
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
            .SecurityReference(defaultAuth())
            .forPaths(PathSelectors.any())
            .build();
    }

    public ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private List<SecurityReference> defaultAlt() {
        AuthorizationScope authorizationScope = new AuthorizationScope(
            "global", "accessEverything"
        );
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = authorizationScope;
        SecurityReference reference = new SecurityReference("JWT", scopes);
        List<SecurityReference> auths = new ArrayList<>();
        auths.add(reference);
        return auths;
    }
}