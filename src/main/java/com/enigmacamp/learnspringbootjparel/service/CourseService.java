package com.enigmacamp.learnspringbootjparel.service;

import com.enigmacamp.learnspringbootjparel.model.Course;
import org.springframework.data.domain.Page;

public interface CourseService {
    Course add(Course course);
    Page<Course> list(Integer page, Integer size, String direction, String sortBy);
}
