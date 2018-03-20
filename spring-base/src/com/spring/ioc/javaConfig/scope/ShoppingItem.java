package com.spring.ioc.javaConfig.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
/*
 * @Configuration也可以实例化该bean,不过是通过CGLIB的方式生成的对象,如果两个注解同时使用,最终还是通过CGLIB实例化对象
 */
//@Configuration
public class ShoppingItem{
	private String name;
	private String price;
	
	public ShoppingItem() {
		super();
	}
	public ShoppingItem(@Value("${name}")String name, @Value("${price}")String price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ShoppingItem [name=" + name + ", price=" + price + "]";
	}
}