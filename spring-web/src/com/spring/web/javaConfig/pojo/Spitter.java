package com.spring.web.javaConfig.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spitter {
	private long id;
	@NotNull
	@Size(min=2,max=30)
	private String firstName;
	@NotNull
	@Size(min=2,max=30)
	private String lastName;
	@NotNull
	@Size(min=5,max=16)
	private String userName;
	@NotNull
	@Size(min=5,max=25)
	private String password;
	
	public Spitter() {
	}
	
	public Spitter(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public Spitter(long id, String firstName, String lastName, String userName, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public boolean equals(Object that) {
      return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password", "email");
    }
    
    @Override
    public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "username", "password", "email");
    }
}
