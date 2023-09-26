package com.project.crudspring.exceptions;

public class RecordNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(Long id) {
		super(String.format("Registro não encontrado com o id: %s", id));
	}
}
