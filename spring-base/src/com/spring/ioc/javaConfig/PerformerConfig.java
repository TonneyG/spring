package com.spring.ioc.javaConfig;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan
public class PerformerConfig {
	@Bean
	@Profile("prd")
	public Performer performer(){
		Performer performer = new Performer();
		performer.setName("周杰伦");
		return performer;
	}
	
	@Bean
	@Profile("dev")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Performer performer2(){
		Performer performer = new Performer();
		performer.setName("林俊杰");
		return performer;
	}
}
