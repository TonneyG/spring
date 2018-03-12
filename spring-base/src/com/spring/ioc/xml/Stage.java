package com.spring.ioc.xml;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Stage implements InitializingBean,DisposableBean{
	/**
	 * 配置xml实现初始化和销毁
	 */
	public void turnOnLight(){
		System.out.println("舞台灯开启");
	}
	
	public void turnOffLight(){
		System.out.println("舞台灯关闭");
	}

	/**
	 * 实现接口初始化和销毁
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("观众保持安静");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("观众鼓掌");
	}
}
