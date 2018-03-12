package com.spring.ioc.javaConfig;

public class Violin implements Instrument{
	private String name = "小提琴";
	private String song = "viva la vida";
	
	@Override
	public void play() {
		System.out.println("演奏"+name+"版本的"+song);
	}
}
