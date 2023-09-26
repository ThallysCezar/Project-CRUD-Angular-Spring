package com.project.crudspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.crudspring.domains.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
 