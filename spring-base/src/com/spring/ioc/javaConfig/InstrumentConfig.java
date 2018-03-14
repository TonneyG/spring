package com.spring.ioc.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ComponentScan 默认开启,扫描该类及子包,不一定需要,当需要扫描指定包的时候添加
@Import(PerformerConfig.class)
//@ImportResource("classpath:xxx.xml") 引入已有的xml配置文件
public class InstrumentConfig {
	@Bean
	public Instrument piano(){
		return new Piano();
	}
}
