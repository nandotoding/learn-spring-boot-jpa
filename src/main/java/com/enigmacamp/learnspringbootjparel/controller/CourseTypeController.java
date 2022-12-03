package com.enigmacamp.learnspringbootjparel.controller;

import com.enigmacamp.learnspringbootjparel.model.CourseType;
import com.enigmacamp.learnspringbootjparel.model.request.CourseTypeRequest;
import com.enigmacamp.learnspringbootjparel.model.response.PagingResponse;
import com.enigmacamp.learnspringbootjparel.model.response.SuccessResponse;
import com.enigmacamp.learnspringbootjparel.service.CourseTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course-types")
public class CourseTypeController {
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity addCourseType(@RequestBody CourseTypeRequest courseTypeRequest) {
        CourseType courseType = modelMapper.map(courseTypeRequest, CourseType.class);
        CourseType ct = courseTypeService.add(courseType);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successfully added course type", ct));
    }

    @GetMapping
    public ResponseEntity getAllCourseTypes(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<CourseType> courseTypes = courseTypeService.list(page, size, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Successfully got all course types", courseTypes));
    }
}
