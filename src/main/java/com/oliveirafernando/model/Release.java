package com.oliveirafernando.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "release")
public class Release {

	@Id
	@SequenceGenerator(name = "release_seq", sequenceName = "release_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "release_seq")
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private LocalDate dueDate;
	
	@Getter
	@Setter
	private LocalDate paymentDate;
	
	@Getter
	@Setter
	private BigDecimal value;
	
	@Getter
	@Setter
	private String note;
	
	@Enumerated(value = EnumType.STRING)
	@Getter
	@Setter
	private ReleaseTypeEnum type;
	
	@ManyToOne
	@Getter
	@Setter
	@JoinColumn(name = "category_fk")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "person_fk")
	@Getter
	@Setter
	private Person person;

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
		Release other = (Release) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
