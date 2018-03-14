package com.spring.ioc.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerformerConfig {
	@Bean
	public Performer performer(){
		Performer performer = new Performer();
		performer.setName("周杰伦");
		return performer;
	}
}
