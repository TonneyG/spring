package com.spring.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements InitializingBean{
	private Map<Integer,String> map = new HashMap<Integer,String>();
	
	public String play(int number){
		return map.get(number);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		map.put(1, "告白气球");
		map.put(2, "修炼爱情");
		map.put(3, "不为谁而作的歌");
		map.put(4, "我怀念的");
		map.put(5, "我们的爱");
	}
}
