package com.enigmacamp.learnspringbootjparel.repository;

import com.enigmacamp.learnspringbootjparel.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, String> {
}
