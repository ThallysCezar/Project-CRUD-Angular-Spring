package com.project.crudspring.enums.converters;

import java.util.stream.Stream;

import com.project.crudspring.enums.CategoryEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class CategoriesConverter implements AttributeConverter<CategoryEnum, String>{

	@Override
	public String convertToDatabaseColumn(CategoryEnum categoryenum) {
		if(categoryenum == null) {
			return null;
		}
		return categoryenum.getValue();
	}

	@Override
	public CategoryEnum convertToEntityAttribute(String value) {
		if (value == null) {
			return null;
		}

		return Stream.of(CategoryEnum.values()).filter(c -> c.getValue().equals(value)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	
}
