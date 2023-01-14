package com.spring.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class OctBatch1Application {

	public static void main(String[] args) {
		SpringApplication.run(OctBatch1Application.class, args);
	}
	@Bean
	public WebMvcConfigurer WebMvcConfigurerAdapter() {
		return new org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
			}
		};
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis((com.google.common.base.Predicate<RequestHandler>) RequestHandlerSelectors.any())
				.paths((com.google.common.base.Predicate<String>) PathSelectors.any()).build();
	}

}