package com.spring.ioc.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ioc.javaConfig.Instrument;
import com.spring.ioc.javaConfig.InstrumentConfig;
import com.spring.ioc.javaConfig.Performer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=InstrumentConfig.class)
public class IocJavaConfigTest {
	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();
	@Autowired
	private Performer performer;
	@Autowired
	private Instrument instrument;
	
	@Test
	public void testInstrument(){
		performer.setInstrument(instrument);
		instrument.play();
	}
	
	//main方法测试
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(InstrumentConfig.class);
		Instrument instrument = (Instrument) ctx.getBean("piano");
		instrument.play();
	}
}
