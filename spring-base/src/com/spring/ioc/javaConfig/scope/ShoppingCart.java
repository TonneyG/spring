package com.spring.ioc.javaConfig.scope;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
	private List<ShoppingItem> goods;

	public List<ShoppingItem> getGoods() {
		return goods;
	}

	public void setGoods(List<ShoppingItem> goods) {
		this.goods = goods;
	}
}

