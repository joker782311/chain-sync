package com.jt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author com.jt
 * @date 2024/8/3 17:08
 */

@Configuration // 标明是配置类
@EnableSwagger2 //开启swagger功能
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //通过包路径来指定哪些Controller中的API需要被Swagger扫描并生成文档。
                //这里指定了"com.yourcompany.yourproject.controller"包及其子包中的所有Controller。
                .apis(RequestHandlerSelectors.basePackage("com.com.jt.controller"))
                //扫描所有路径
                .paths(PathSelectors.any())
                .build()
                //设置API的元数据信息，如标题、描述、版本等。
                //这些信息会显示在Swagger UI的顶部。
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("工地项目")
                .description("项目的API描述")
                .version("1.0")
                .build();
    }

}
