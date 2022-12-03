package com.enigmacamp.learnspringbootjparel.service;

import com.enigmacamp.learnspringbootjparel.model.Course;
import com.enigmacamp.learnspringbootjparel.model.CourseType;
import org.springframework.data.domain.Page;

public interface CourseTypeService {
    CourseType add(CourseType courseType);
    Page<CourseType> list(Integer page, Integer size, String direction, String sortBy);
}
