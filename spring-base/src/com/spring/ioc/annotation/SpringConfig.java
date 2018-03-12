package com.spring.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public Instrument piano(){
		return new Piano();
	}
}
