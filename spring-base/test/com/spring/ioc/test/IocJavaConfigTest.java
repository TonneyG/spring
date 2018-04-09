package com.spring.ioc.test;

import java.io.UnsupportedEncodingException;

import javax.sql.DataSource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ioc.javaConfig.Instrument;
import com.spring.ioc.javaConfig.Performer;
import com.spring.ioc.javaConfig.SystemConfig;
import com.spring.ioc.javaConfig.scope.ShoppingCart;
import com.spring.ioc.javaConfig.scope.ShoppingItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfig.class)
@ActiveProfiles("dev")
//@TestPropertySource(value="classpath:app.properties")
public class IocJavaConfigTest {
	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();
	@Autowired
	private Performer performer;
	@Autowired
	private Instrument piano;
	@Autowired
	private DataSource dataSource;
	//在进行@Autowired自动装配时,如果bean有无参构造器则调用有参构造器,否则使用无参构造器进行装配
	@Autowired
	private ShoppingItem item;
	@Autowired
	private ShoppingCart cart;
	
	/* @TestPropertySource和@PropertySource注解都可以读取properties文件的值
	 * @TestPropertySource用于单元测试,上下文@TestPropertySource或@PropertySource只需要其中一个
	 */
	@Autowired
	private Environment env;
	@Value("${name}")
	private String name;
	
	//验证@Profile和@ActiveProfile
	@Test
	public void testInstrument(){
		performer.setInstrument(piano);
		piano.play();
	}
	
	@Test
	public void testScope() throws UnsupportedEncodingException{
		item.setName(new String(env.getProperty("name").getBytes(),"UTF-8"));
		item.setPrice(env.getProperty("price"));
		System.out.println(item);
	}
	
	//main方法测试
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemConfig.class);
		//通过bean注解注册bean
		Instrument instrument = (Instrument) ctx.getBean("piano");
		instrument.play();
		
		//通过ComponentScan和Component注解注册bean
		ShoppingItem item = (ShoppingItem) ctx.getBean("shoppingItem");
		System.out.println(item);
	}
}
