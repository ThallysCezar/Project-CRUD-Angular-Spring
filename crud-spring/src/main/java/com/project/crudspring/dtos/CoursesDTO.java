package com.project.crudspring.dtos;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoursesDTO {
	
	private Long _id;
	
	@NotBlank
    @NotNull
    @Length(min = 5, max = 200)
	private String name;

	@NotNull
	@Length(max = 10)
	private String category;
	
	private List<LessonDTO> lessons;
}
