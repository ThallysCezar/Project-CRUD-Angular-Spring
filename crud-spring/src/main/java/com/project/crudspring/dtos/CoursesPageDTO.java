package com.project.crudspring.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CoursesPageDTO {

	public List<CoursesDTO> coursesList; 
	public long totalElements;
	public long totalPages;
	
	public CoursesPageDTO(List<CoursesDTO> coursesList, long totalElements, int totalPages) {
	    this.coursesList = coursesList;
	    this.totalElements = totalElements;
	    this.totalPages = totalPages;
	}
}
