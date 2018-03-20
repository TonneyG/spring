package com.spring.ioc.javaConfig.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition{
	/*ConditionContext API：
	 * 	BeanDefinitionRegistry getRegistry();
	 *	返回的BeanDefinitionRegistry检查bean定义
	 *
	 *	ConfigurableListableBeanFactory getBeanFactory();
	 *	返回的ConfigurableListableBeanFactory检查bean是否存在,甚至探查bean的属性
	 *
	 *	Environment getEnvironment();
	 *	返回的Environment检查环境变量是否存在以及它的值是什么
	 *
	 *	ResourceLoader getResourceLoader();
	 *	加载资源
	 *
	 *	ClassLoader getClassLoader();、
	 *	返回的ClassLoader加载并检查类是否存在
	 */
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		System.out.println(env.getProperty("JAVA_HOME"));
		return env.containsProperty("magic");
	}

}
