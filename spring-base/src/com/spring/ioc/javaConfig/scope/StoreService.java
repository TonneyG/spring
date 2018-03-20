package com.spring.ioc.javaConfig.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class StoreService {
	@Autowired
	private ShoppingCart shoppingCart;

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
}
