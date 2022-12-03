package com.enigmacamp.learnspringbootjparel.controller;

import com.enigmacamp.learnspringbootjparel.model.CourseInfo;
import com.enigmacamp.learnspringbootjparel.model.request.CourseInfoRequest;
import com.enigmacamp.learnspringbootjparel.model.response.PagingResponse;
import com.enigmacamp.learnspringbootjparel.model.response.SuccessResponse;
import com.enigmacamp.learnspringbootjparel.service.CourseInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course-info")
public class CourseInfoController {
    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity addCourseInfo(@RequestBody CourseInfoRequest courseInfoRequest) {
        CourseInfo courseInfo = modelMapper.map(courseInfoRequest, CourseInfo.class);
        CourseInfo ci = courseInfoService.add(courseInfo);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successfully added course info", ci));
    }

    @GetMapping
    public ResponseEntity getAllCourseInfo(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<CourseInfo> courseInfos = courseInfoService.list(page, size, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Successfully got course info", courseInfos));
    }
}
