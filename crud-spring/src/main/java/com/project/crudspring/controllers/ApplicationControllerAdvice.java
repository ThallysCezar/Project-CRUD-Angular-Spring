package com.project.crudspring.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.project.crudspring.exceptions.RecordNotFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(RecordNotFoundException ex) {
		return "Error: " + ex.getMessage();
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleEnumNotFound(IllegalArgumentException exp) {
		return "Categoria não encontrada, tente passar uma categoria válida: Back-end ou Front-end.";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		StringBuilder errorMessage = new StringBuilder();

		for (FieldError error : fieldErrors) {
			errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("\n");
		}

		return errorMessage.toString();
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleConstraintViolationException(ConstraintViolationException exp) {
		return exp.getConstraintViolations().stream().map(error -> error.getPropertyPath() + " " + error.getMessage()).reduce("", (acc, error) -> acc + error + "\n");
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleConstraintViolationException(MethodArgumentTypeMismatchException exp) {
		if (exp != null && exp.getRequiredType() != null) {
			String type = exp.getRequiredType().getName();
			String[] typeParts = type.split("\\.");
			String typeName = typeParts[typeParts.length - 1];
			return exp.getName() + " should be of Type " + typeName;
		}
		return "Argument type not valid";
	}
	
}
