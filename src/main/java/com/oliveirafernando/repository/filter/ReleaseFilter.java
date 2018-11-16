package com.oliveirafernando.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class ReleaseFilter {
	
	@Getter @Setter
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Getter @Setter
	private LocalDate dueDateFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Getter @Setter
	private LocalDate dueDateTo;

}
