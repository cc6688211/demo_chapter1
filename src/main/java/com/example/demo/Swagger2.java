package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//引入注解启用Swagger2
@Configuration
@EnableSwagger2
public class Swagger2 {
	/**
	 * 通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
	 * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现， 本例采用指定扫描的包路径来定义，
	 * Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
	 * 
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).paths(PathSelectors.any()).build();
	}

	/**
	 * 构建api主页信息
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot2.0学习")
				.description("更多Spring Boot2.0相关文章请关注https://blog.csdn.net/u010904188/article/category/7690462")
				.termsOfServiceUrl("https://blog.csdn.net/")
				.contact(
						new Contact("cc", "https://blog.csdn.net/u010904188/article/category/7690462", "888888@qq.com"))
				.version("1.0").build();
	}
}
