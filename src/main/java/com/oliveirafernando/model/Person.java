package com.oliveirafernando.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "name")
	@Size(min = 3, max = 50)
	@NotNull
	@Getter
	@Setter
	private String name;
	
	@Embedded
	@Getter
	@Setter
	private Address address;
	
	@Column(name = "is_active")
	@NotNull
	@Getter
	@Setter
	private Boolean isActive;
	
	@JsonIgnore
	@Transient
	public boolean isInactive() {
		return !this.isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
