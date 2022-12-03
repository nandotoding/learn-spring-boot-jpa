package com.enigmacamp.learnspringbootjparel.service;

import com.enigmacamp.learnspringbootjparel.model.CourseInfo;
import org.springframework.data.domain.Page;

public interface CourseInfoService {
    CourseInfo add(CourseInfo courseInfo);
    Page<CourseInfo> list(Integer page, Integer size, String direction, String sortBy);
}
