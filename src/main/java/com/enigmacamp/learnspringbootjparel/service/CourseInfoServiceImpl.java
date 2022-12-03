package com.enigmacamp.learnspringbootjparel.service;

import com.enigmacamp.learnspringbootjparel.model.CourseInfo;
import com.enigmacamp.learnspringbootjparel.repository.CourseInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {
    private final CourseInfoRepo courseInfoRepo;

    @Autowired
    public CourseInfoServiceImpl(CourseInfoRepo courseInfoRepo) {
        this.courseInfoRepo = courseInfoRepo;
    }

    @Override
    public CourseInfo add(CourseInfo courseInfo) {
        return courseInfoRepo.save(courseInfo);
    }

    @Override
    public Page<CourseInfo> list(Integer page, Integer size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return courseInfoRepo.findAll(pageable);
    }
}
