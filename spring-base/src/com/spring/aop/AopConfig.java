package com.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.spring.aop.declareParents.EncoreableIntroducer;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AopConfig {
	//不带@Around的aop代理
	/*@Bean
	public Audience audience(){
		return new Audience();
	}*/
	
	@Bean
	public Audience2 audience2(){
		return new Audience2();
	}
	
	@Bean
	public TrackCounter trackCounter(){
		return new TrackCounter();
	}
	
	@Bean
	public EncoreableIntroducer encoreableIntroducer(){
		return new EncoreableIntroducer();
	}
	
}
