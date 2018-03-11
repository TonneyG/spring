package com.spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ioc.Instrument;

public class IocTest {
	@Test
	public void testPiano(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		Instrument instrument = (Instrument) ctx.getBean("piano");
		instrument.play();
	}
}
