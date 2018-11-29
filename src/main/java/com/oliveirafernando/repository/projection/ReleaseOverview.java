package com.oliveirafernando.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.oliveirafernando.model.ReleaseTypeEnum;

import lombok.Getter;
import lombok.Setter;

public class ReleaseOverview {

	public ReleaseOverview(
			Long id, 
			String description, 
			LocalDate dueDate, 
			LocalDate paymentDate, 
			BigDecimal value,
			ReleaseTypeEnum type, 
			String category, 
			String person
		) {
		
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.value = value;
		this.type = type;
		this.category = category;
		this.person = person;
	}

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
	private ReleaseTypeEnum type;

	@Getter
	@Setter
	private String category;

	@Getter
	@Setter
	private String person;

}
