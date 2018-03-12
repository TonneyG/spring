package com.spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ioc.xml.Instrument;
import com.spring.ioc.xml.Performer;


public class IocTest {
	@Test
	public void testXml(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		Instrument instrument = (Instrument) ctx.getBean("piano");
		instrument.play();
		Performer performer = (Performer) ctx.getBean("performer");
		System.out.println(performer.getName()+" "+performer.getInstrument());
		//测试自动装配策略
		Performer performer2 = (Performer) ctx.getBean("performer2");
		System.out.println(performer2.getInstrument());
		Performer performer3 = (Performer) ctx.getBean("performer3");
		System.out.println(performer3.getInstrument());
	}
	
	@Test
	public void testAnnotation(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
		com.spring.ioc.annotation.Performer performer = (com.spring.ioc.annotation.Performer) ctx.getBean("performer");
		System.out.println(performer.getInstrument());
	}
	
	@Test
	public void testJavaConfig(){
		
	}
}
