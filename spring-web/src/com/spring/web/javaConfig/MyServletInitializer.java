package com.spring.web.javaConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

import com.spring.web.javaConfig.filter.MyFilter;
import com.spring.web.javaConfig.servlet.MyServlet;

public class MyServletInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
		myServlet.addMapping("/custom/**");
		
		javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/custom/*");
	}

}
