package com.spring.ioc.javaConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@Import({PerformerConfig.class,Instrument.class})
//@ImportResource("classpath:xxx.xml") 引入已有的xml配置文件
public class SystemConfig {
	@Bean
	@Profile("prd")//@Profile注解在spring3.2之后可以应用于方法之上,3.2之前只能应用于类上
	public DataSource dataSource(){
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/dataSource");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean.getObject();
	}
	
	
	
}
