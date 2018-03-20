package com.spring.ioc.javaConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.spring.ioc.javaConfig.conditional.MagicBean;
import com.spring.ioc.javaConfig.conditional.MagicExistsCondition;
import com.spring.ioc.javaConfig.scope.ShoppingConfig;

@Configuration
@Import({PerformerConfig.class,InstrumentConfig.class,ShoppingConfig.class})
//@ImportResource("classpath:xxx.xml") 引入已有的xml配置文件
public class SystemConfig {
	@Bean
	//@Profile("prd")//@Profile注解在spring3.2之后可以应用于方法之上,3.2之前只能应用于类上
	public DataSource dataSource(){
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/dataSource");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean.getObject();
	}
	
	/*
	 * 测试条件化配置注解@Conditional
	 */
	@Bean
	@Conditional(MagicExistsCondition.class)
	public MagicBean magicBean(){
		return new MagicBean();
	}
	
	/*
	 * 不需要显示申明配置这个bean
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
}
