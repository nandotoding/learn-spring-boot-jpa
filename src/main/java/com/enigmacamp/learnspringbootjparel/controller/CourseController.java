package com.enigmacamp.learnspringbootjparel.controller;

import com.enigmacamp.learnspringbootjparel.model.Course;
import com.enigmacamp.learnspringbootjparel.model.request.CourseRequest;
import com.enigmacamp.learnspringbootjparel.model.response.PagingResponse;
import com.enigmacamp.learnspringbootjparel.model.response.SuccessResponse;
import com.enigmacamp.learnspringbootjparel.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity addCourse(@RequestBody CourseRequest course) {
        Course newCourse = modelMapper.map(course, Course.class);
        Course c = courseService.add(newCourse);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Added course successfully", c));
    }

    @GetMapping
    public ResponseEntity getAllStudents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<Course> courses = courseService.list(page, size, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Got courses successfully", courses));
    }
}
