package com.oliveirafernando.exceptionhandler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.Getter;
import lombok.Setter;

@ControllerAdvice
public class MyResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String errorMessage = this.messageSource.getMessage("message.invalid_schema", null,
				LocaleContextHolder.getLocale());
		String technicalMessage = ex.getCause().getMessage();
		List<Error> errors = Arrays.asList(new Error(errorMessage, technicalMessage));

		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Error> errors = createErrorList(ex.getBindingResult());
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	private List<Error> createErrorList(BindingResult bindingResult) {
		return bindingResult
				.getFieldErrors()
				.stream()
				.map(fieldError -> 
					new Error(
							messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()), 
							fieldError.toString()
					)
				)
				.collect(Collectors.toList());
	}

	public static class Error {

		@Getter
		@Setter
		private String customMessage;

		@Getter
		@Setter
		private String technicalMessage;

		public Error(String customMessage, String technicalMessage) {
			this.customMessage = customMessage;
			this.technicalMessage = technicalMessage;
		}
	}
}
