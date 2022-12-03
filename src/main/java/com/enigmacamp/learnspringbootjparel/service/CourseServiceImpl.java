package com.enigmacamp.learnspringbootjparel.service;

import com.enigmacamp.learnspringbootjparel.model.Course;
import com.enigmacamp.learnspringbootjparel.model.CourseInfo;
import com.enigmacamp.learnspringbootjparel.repository.CourseInfoRepo;
import com.enigmacamp.learnspringbootjparel.repository.CourseRepo;
import com.enigmacamp.learnspringbootjparel.repository.CourseTypeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final CourseInfoRepo courseInfoRepo;
    private final CourseTypeRepo courseTypeRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, CourseInfoRepo courseInfoRepo, CourseTypeRepo courseTypeRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.courseInfoRepo = courseInfoRepo;
        this.courseTypeRepo = courseTypeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Course add(Course course) {
//        Optional<CourseInfo> gottenCourseInfo = courseInfoRepo.findById(course.getId());
//        CourseInfo newCourseInfo = modelMapper.map(gottenCourseInfo, CourseInfo.class);
//        course.setCourseInfo(newCourseInfo);
        return courseRepo.save(course);
    }

    @Override
    public Page<Course> list(Integer page, Integer size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page -1), size, sort);
        return courseRepo.findAll(pageable);
    }
}
