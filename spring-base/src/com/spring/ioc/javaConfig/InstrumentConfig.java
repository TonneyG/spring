package com.spring.ioc.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={Performer.class,Instrument.class})
public class InstrumentConfig {
	@Bean
	public Instrument piano(){
		return new Piano();
	}
}
