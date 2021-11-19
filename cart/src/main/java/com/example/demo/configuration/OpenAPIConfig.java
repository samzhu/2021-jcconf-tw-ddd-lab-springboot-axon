package com.example.demo.configuration;


import java.util.concurrent.CompletableFuture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
@Profile({"dev", "unittest"})
public class OpenAPIConfig {
  private static final String TITLE = "DDD Demo";
  private static final String DESCRIPTION = "Event Sourcing and CQRS with Axon Framework";
  private static final String VERSION = "1.0.0";
  private static final String TERMS_OF_SERVICE_URL = "";
  private static final String LICENSE = "Apache 2.0";
  private static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
  private static final String CONTACT_NAME = "sam";
  private static final String CONTACT_URL = "https://blog.samzhu.dev";
  private static final String CONTACT_EMAIL = "";

  @Bean
  public Docket api() {
    // @formatter:off
    return new Docket(DocumentationType.SWAGGER_2)
        // 為了顯示 CompletableFuture 內的 DTO 描述
        .genericModelSubstitutes(ResponseEntity.class, CompletableFuture.class)
        .apiInfo(this.apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any())
        // 濾掉預設的與監控路徑
        .paths(
            path -> {
              return !(path.matches("/error")
                  || path.matches("/actuator+(.*)")
                  || path.matches("/profile"));
            })
        .build();
    // @formatter:on
  }

  private ApiInfo apiInfo() {
    // @formatter:off
    return new ApiInfoBuilder()
        .title(TITLE)
        .description(DESCRIPTION)
        .version(VERSION)
        .termsOfServiceUrl(TERMS_OF_SERVICE_URL)
        .contact(this.contact())
        .license(LICENSE)
        .licenseUrl(LICENSE_URL)
        .build();
    // @formatter:on
  }

  private Contact contact() {
    return new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL);
  }
}
