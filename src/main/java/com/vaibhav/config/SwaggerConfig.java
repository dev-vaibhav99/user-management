package com.vaibhav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class SwaggerConfig {

	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.vaibhav.resource"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());

	}

	public ApiInfo apiInfo() {
		 Contact contactInfo =  new Contact("Career Infotech", "www.careerinfotech.com", "info.careerinfotech@gmail.com");
		 
			return new ApiInfo("Spring Boot REST API", 
								"This is For Desc", 
								"v1.0", 
								"URL", 
								contactInfo,
								"Apache License Version 2.0", 
								"https://www.apache.org/licenses/LICENSE-2.0"
							);
		}
}
