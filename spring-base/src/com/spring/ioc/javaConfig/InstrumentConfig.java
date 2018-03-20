package com.spring.ioc.javaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
//@ComponentScan 默认开启,扫描该类及子包,不一定需要,当需要扫描指定包的时候添加
@PropertySource(value="classpath:app.properties",encoding="utf-8")
public class InstrumentConfig {
	/* Environment API：
	 * · env.getRequiredProperty(key)：比如有key值，不然会抛异常
	 * · env.containsProperty(key)：是否包含key
	 * · env.getPropertyAsClass(key, targetType)：属性解析为类
	 */
	@Autowired
	private Environment env;
	
	@Bean
	public Instrument piano(){
		return new Piano();
	}
	
	//使用@autowired装配时,如果容器中存在两个相同类型的bean,可以使用@Primary标注在申明的Bean下或在@autowired装配时指定@Qualifier
	@Bean
	@Primary
	public Instrument violin(){
		System.out.println("商品名："+env.getProperty("name")+" , 价格："+env.getProperty("price"));
		return new Violin();
	}
}
