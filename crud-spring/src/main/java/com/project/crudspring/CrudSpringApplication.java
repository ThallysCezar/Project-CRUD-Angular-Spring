package com.project.crudspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner initDataBase(CoursesRepository courseRepository) {
//		return args -> {
//			courseRepository.deleteAll();
//
//			for (int i = 0; i < 20; i++) {
//
//				Courses c = new Courses();
//				c.setName("Angular com Spring " + i);
//				c.setCategory(CategoryEnum.FRONT_END);
//
//				Lesson l = new Lesson();
//				l.setName("Introducao");
//				l.setYoutubeURL("watch?v=12");
//				l.setCourses(c);
//				c.getLessons().add(l);
//
//				Lesson l1 = new Lesson();
//				l1.setName("Angular");
//				l1.setYoutubeURL("watch?v=21");
//				l1.setCourses(c);
//				c.getLessons().add(l1);
//
//				courseRepository.save(c);
//			}
//		};
//	}

}
