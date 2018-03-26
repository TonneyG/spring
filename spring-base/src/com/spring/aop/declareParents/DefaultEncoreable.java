package com.spring.aop.declareParents;

import org.springframework.stereotype.Component;

@Component
public class DefaultEncoreable implements Encoreable{
	@Override
	public void performEncore() {
		System.out.println("再来一首");
	}
}
