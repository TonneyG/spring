package com.spring.ioc.annotation;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument{
	
	private String name = "钢琴";
	private String song = "viva la vida";
	
	public Piano() {
		super();
	}
	public Piano(String song) {
		this.song = song;
	}
	
	/**
	 * initialization on demand holder方式懒加载单例
	 */
	private static class SingletonHolder{
		static Piano instance = new Piano();
	}
	public static Piano getInstance(){
		return SingletonHolder.instance;
	}

	@Override
	public void play() {
		System.out.println("演奏"+name+"版本的"+song);
	}
}
