package com.project.crudspring.enums;

import java.util.Arrays;

public enum CategoryEnum {

	BACK_END("Back-end"),
	FRONT_END("Front-end");
	
	private String value;
	
	private CategoryEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static CategoryEnum fromString(String category) {
		 return Arrays.stream(values())
                .filter(categoria -> categoria.name().equals(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(category));
    }
	
}