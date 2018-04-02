package com.spring.web.javaConfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan(basePackages={"com.spring.web.javaConfig"},excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {
	
	//TODO 国际化功能
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
	
	/**
	 * 创建TilesConfigurer bean,负责定位和加载Tile定义并协调生成Tiles
	 */
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});//指定Tile定义的位置
		tiles.setCheckRefresh(true);//启用刷新功能
		return tiles;
	}
	
	/**
	 * TileViewResolver bean将逻辑视图名称解析为Tile定义
	 */
	@Bean
	public ViewResolver viewResolver(){
		return new TilesViewResolver();
	}
	/* 或者xml定义
	  <bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>/WEB-INF/layout/tiles.xml</value>
				<value>/WEB-INF/viewstiles.xml</value>
			</list>
		</property>
	  </bean>
	  <bean id="viewResolver" class="org.springframework.web.servlet.view.tiles3.TilesViewResolver"/>
	 */
	
	/**
	 * 由于JSP的标签库缺乏良好的格式，并且JSP只能适用于Servlet的WEB项目，所以也可以使用Thymeleaf
	 * 使用Thymeleaf，需要配置：
	 * ThymeleafViewResolver:将逻辑视图名称解析为Thymeleaf模版视图;
	 * SpringTemplateEngine:处理模版并渲染结果;
	 * TemplateResolver:加载Thymeleaf模版;
	 */
	//Thymeleaf视图解析器
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
	//模版引擎
	@Bean
	public TemplateEngine templateEngine(ITemplateResolver templateResolver){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}
	//模版解析器
	@Bean
	public ITemplateResolver templateResolver(){
		//Themyleaf 3之前
		//TemplateResolver resolver = new ServletContextTemplateResolver(); 
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();  
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		return resolver;
	}
}
