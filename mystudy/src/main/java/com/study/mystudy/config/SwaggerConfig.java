package com.study.mystudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport{
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {	//boot 2.x.x 버전에서 swagger 3.0 적용 위한 핸들러 로케이션 추가
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
		   registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
	}
	
	@Bean
	public Docket targetApi() {
		return new Docket(DocumentationType.OAS_30)
		.useDefaultResponseMessages(false)
		.select()
		.apis(RequestHandlerSelectors.any())
		.paths(PathSelectors.any())
		.build()
		.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot Study")
				.description("열심히 공부를 해봅시당")
				.version("3.0")
				.build();
	}
}
