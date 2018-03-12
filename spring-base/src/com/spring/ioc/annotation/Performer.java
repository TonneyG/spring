package com.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Performer {
	private String name;
	@Autowired
	@Qualifier("piano")
	private Instrument instrument;
	
	public Performer() {
		super();
	}
	public Performer(Instrument instrument) {
		super();
		this.instrument = instrument;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
}
