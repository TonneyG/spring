package com.spring.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.aop.AopConfig;
import com.spring.aop.Audience;
import com.spring.aop.CDPlayer;
import com.spring.aop.Performance;
import com.spring.aop.declareParents.Encoreable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopConfig.class)
public class AopJavaConfigTest {
	@Autowired
	private Audience audience;
	
	@Autowired
	private Performance performance;
	@Autowired
	private CDPlayer cdplayer;
	
	@Test
	public void one(){
		performance.perform();
		//测试@DeclareParents的作用
		Encoreable e = (Encoreable)performance;
		e.performEncore();
	}
	
	@Test
	public void testCDPlayer(){
		System.out.println("播放："+cdplayer.play(2));
	}
}
