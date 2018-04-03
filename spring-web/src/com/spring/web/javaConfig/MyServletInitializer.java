package com.spring.web.javaConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.web.javaConfig.filter.MyFilter;
import com.spring.web.javaConfig.servlet.MyServlet;

public class MyServletInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
		myServlet.addMapping("/custom/**");
		
		javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/custom/*");
		
		// 可以使用如下方式创建DispatcherServlet,并支持multipart请求,
		// 或者在继承AbstractAnnotationConfigDispatcherServletInitializer的类中的重载customizeRegistration()实现支持multipart请求
		/*DispatcherServlet ds = new DispatcherServlet();
		Dynamic registration = servletContext.addServlet("appServlet", ds);
		registration.addMapping("/");
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads"));*/
	}

}
