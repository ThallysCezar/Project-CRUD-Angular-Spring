package com.project.crudspring.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudspring.dtos.CoursesDTO;
import com.project.crudspring.services.CoursesService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
	
	private final CoursesService coursesService;

//	@GetMapping
//	public CoursesPageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page, @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {
//		return coursesService.list(page, pageSize);
//	}
	
	@GetMapping
	public List<CoursesDTO> list() {
		return coursesService.list();
	}

	@GetMapping("/{id}")
	public CoursesDTO findById(@PathVariable @NotNull @Positive Long id) {
		return coursesService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CoursesDTO create(@RequestBody @Valid CoursesDTO courses) {
		return coursesService.create(courses);
	}

	@PutMapping("/{id}")
	public CoursesDTO update(@PathVariable @NotNull @Positive Long id,
			@RequestBody @Valid @NotNull CoursesDTO courses) {
		return coursesService.update(id, courses);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotNull @Positive Long id) {
		coursesService.delete(id);
	}
}
