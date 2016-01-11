package com.webconfig;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("classpath:/com/resources/ValidationMessages.properties")
@ComponentScan(basePackages={"com"},
excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {
	@Bean
	public	static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
	}
/*	@Bean
	public MultipartResolver multipartResolver() throws IOException {
	return new StandardServletMultipartResolver();
	}*/
	/*@Bean
	LocalValidatorFactoryBean localValidatorFactoryBean(ResourceBundleMessageSource resourceBundleMessageSource){
		return new LocalValidatorFactoryBean(resourceBundleMessageSource);
	}*/
}
