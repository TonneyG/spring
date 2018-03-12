package com.spring.ioc.xml;

public class Performer {
	private String name;
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
