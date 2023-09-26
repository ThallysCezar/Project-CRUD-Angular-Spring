package com.project.crudspring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.crudspring.converts.CoursesConverter;
import com.project.crudspring.domains.Courses;
import com.project.crudspring.dtos.CoursesDTO;
import com.project.crudspring.exceptions.RecordNotFoundException;
import com.project.crudspring.repositories.CoursesRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CoursesService {

	private final CoursesRepository courseRepository;
	private final CoursesConverter coursesConverter;
	
	public CoursesService(CoursesRepository courseRepository, CoursesConverter coursesConverter) {
		this.courseRepository = courseRepository;
		this.coursesConverter = coursesConverter;
	}
	
//	public CoursesPageDTO list(int page, int pageSize) {
//	    Page<Courses> pageCourse = courseRepository.findAll(PageRequest.of(page, pageSize));
//	    List<CoursesDTO> coursesList = coursesConverter.entityListToDTOList(pageCourse.getContent());
//	    return new CoursesPageDTO(coursesList, pageCourse.getTotalElements(), pageCourse.getTotalPages());
//	}
	
	public Page<CoursesDTO> list(Pageable pageable) {
		Page<Courses> page = courseRepository.findAll(pageable);
		return coursesConverter.entityPageToDTOPage(page);
	}
	
	public CoursesDTO findById(@NotNull @Positive Long id) {
		Courses course = courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
		return coursesConverter.entityToDTO(course);
	}
	
	public CoursesDTO create(@Valid CoursesDTO coursesDTO) {
        Courses course = coursesConverter.dtoToEntity(coursesDTO);
        return coursesConverter.entityToDTO(courseRepository.save(course));
    }
	
	public CoursesDTO update(@NotNull @Positive Long id, @Valid CoursesDTO coursesDTO) {
        Courses existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        Courses updatedCourse = coursesConverter.dtoToEntity(coursesDTO);
        updatedCourse.setId(existingCourse.getId());
        return coursesConverter.entityToDTO(courseRepository.save(updatedCourse));
    }
	
	public void delete(@NotNull @Positive Long id) {
		courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
	}
	
}
