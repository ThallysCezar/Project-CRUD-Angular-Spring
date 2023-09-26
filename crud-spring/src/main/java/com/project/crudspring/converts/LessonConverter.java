package com.project.crudspring.converts;

import org.springframework.stereotype.Component;

import com.project.crudspring.domains.Courses;
import com.project.crudspring.domains.Lesson;
import com.project.crudspring.dtos.LessonDTO;

@Component
public class LessonConverter {

	public Lesson dtoToEntity(LessonDTO lessonDTO, Courses courses) {
        Lesson lesson = new Lesson();
		lesson.setId(lessonDTO.getId());
		lesson.setName(lessonDTO.getName());
		lesson.setYoutubeURL(lessonDTO.getYoutubeURL());
		lesson.setCourses(courses);
		return lesson;
    }

    public LessonDTO entityToDTO(Lesson lesson) {
    	LessonDTO lessonDTO = new LessonDTO();
		lessonDTO.setId(lesson.getId());
		lessonDTO.setName(lesson.getName());
		lessonDTO.setYoutubeURL(lesson.getYoutubeURL());
		return lessonDTO;
    }
}
