package com.webflow.domain;

import java.util.HashMap;
import java.util.Map;

public class Pizza {
	public static void main(String[] args) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("abc", "123");
		map.put("ace", "135");
		map.put("bcd", "159");
		map.put("cae", "258");
		System.out.println(map.toString());
		String str = "www.suning.com";
		String[] s = str.split("[?]");
		System.out.println(s.length);
	}
}
