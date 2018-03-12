package com.spring.ioc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ioc.javaConfig.Instrument;
import com.spring.ioc.javaConfig.InstrumentConfig;
import com.spring.ioc.javaConfig.Performer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=InstrumentConfig.class)
public class IocJavaConfigTest {
	/*@Autowired
	private Performer performer;*/
	@Autowired
	private Instrument instrument;
	
	@Test
	public void one(){
		System.out.println(instrument);
	}
}
