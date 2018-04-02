package com.spring.web.javaConfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"com.spring.web.javaConfig"},excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {
	
	/*@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}*/
	
	/**
	 * 注册国际化需要用到的消息源
	 * basename属性可以设置为在类路径下("classpath:"前缀开头)、文件系统中("file:"前缀开头)或Web应用的根路径(没有前缀)
	 * 
	 */
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("file:///etc/spittr/messages");
		messageSource.setCacheSeconds(10);
		return messageSource;
	}
}
