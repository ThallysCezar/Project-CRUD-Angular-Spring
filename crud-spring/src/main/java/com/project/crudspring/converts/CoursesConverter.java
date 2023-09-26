package com.project.crudspring.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.project.crudspring.domains.Courses;
import com.project.crudspring.domains.Lesson;
import com.project.crudspring.dtos.CoursesDTO;
import com.project.crudspring.dtos.LessonDTO;
import com.project.crudspring.enums.CategoryEnum;

@Component
public class CoursesConverter {
	
	private final LessonConverter lessonConverter;

    public CoursesConverter(LessonConverter lessonConverter) {
        this.lessonConverter = lessonConverter;
    }


	public Courses dtoToEntity(CoursesDTO dto) {
		Courses courses = new Courses();
		courses.setId(dto.get_id());
		courses.setName(dto.getName());
		CategoryEnum categoryEnum = getCategoryEnum(dto.getCategory());
		courses.setCategory(categoryEnum);
		List<Lesson> lessonList = dto.getLessons().stream()
                .map(lessonDTO -> lessonConverter.dtoToEntity(lessonDTO, courses))
                .collect(Collectors.toList());

		courses.setLessons(lessonList);
		return courses;
	}

	public CoursesDTO entityToDTO(Courses courses) {
		final var coursesDTO = new CoursesDTO();
		coursesDTO.set_id(courses.getId());
		coursesDTO.setName(courses.getName());
		coursesDTO.setCategory(courses.getCategory().getValue());
		List<LessonDTO> lessonDTOList = courses.getLessons().stream().map(lessonConverter::entityToDTO)
				.collect(Collectors.toList());

		coursesDTO.setLessons(lessonDTOList);
		return coursesDTO;
	}
    
    public List<CoursesDTO> entityListToDTOList(List<Courses> coursesList) {
        return coursesList.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
    
    public Page<CoursesDTO> entityPageToDTOPage(Page<Courses> page) {
        return page.map(this::entityToDTO);
    }
    
    private CategoryEnum getCategoryEnum(String category) {
        for (CategoryEnum categoryEnum : CategoryEnum.values()) {
            if (categoryEnum.getValue().equalsIgnoreCase(category)) {
                return categoryEnum;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + category);
    }
}
