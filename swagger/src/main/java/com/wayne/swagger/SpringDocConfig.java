package com.wayne.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringDocConfig {

        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI()
                    .info(this.getApiInfo());
        }

        private Info getApiInfo() {
          return   new Info().title("Spring Cloud Swagger")
                    .description("Spring Cloud Swagger 練習");
        }

//    @Bean("commonGroupApi")
//    public GroupedOpenApi webGroupApi() {
//        return GroupedOpenApi.builder().group("common通用模块组")
//                .pathsToMatch("/common/**")
//                .build();
//    }
//
//    @Bean("adminGroupApi")
//    public GroupedOpenApi adminGroupApi() {
//        return GroupedOpenApi.builder().group("admin模块组")
//                .pathsToMatch("/admin/**")
//                .build();
//    }
}