package com.oliveirafernando.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Address {
	
	@Getter @Setter
	private String street;
	
	@Getter @Setter
	private String number;
	
	@Getter @Setter
	private String complement;
	
	@Getter @Setter
	private String neighborhood;
	
	@Column(name = "zip_code")
	@Getter @Setter
	private String zipCode;
	
	@Getter @Setter
	private String city;
	
	@Getter @Setter
	private String state;
	
}
