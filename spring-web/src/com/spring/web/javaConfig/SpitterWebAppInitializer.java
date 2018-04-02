package com.spring.web.javaConfig;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.web.javaConfig.filter.MyFilter;

public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	//指定配置类
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	//将DispatcherServlet映射到"/"
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	//启用Servlet 3.0对multipart的支持
	@Override
	protected void customizeRegistration(Dynamic registration) {
		//registration.setLoadOnStartup(1); //设置load-on-startup优先级
		//registration.setInitParameter("xxx", "xxx"); //设置初始化参数
		
		//上传文件临时目录为"/tmp/spittr/uploads"
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads"));
	}

	//注册Filter,映射到DispatcherServlet,另一种方式是创建实现WebApplicationInitializer的类并注册
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new MyFilter()};
	}

}
