package com.enigmacamp.learnspringbootjparel.service;

import com.enigmacamp.learnspringbootjparel.model.Course;
import com.enigmacamp.learnspringbootjparel.model.CourseType;
import com.enigmacamp.learnspringbootjparel.repository.CourseTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    private final CourseTypeRepo courseTypeRepo;

    @Autowired
    public CourseTypeServiceImpl(CourseTypeRepo courseTypeRepo) {
        this.courseTypeRepo = courseTypeRepo;
    }

    @Override
    public CourseType add(CourseType courseType) {
        return courseTypeRepo.save(courseType);
    }

    @Override
    public Page<CourseType> list(Integer page, Integer size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page -1), size, sort);
        return courseTypeRepo.findAll(pageable);
    }
}
