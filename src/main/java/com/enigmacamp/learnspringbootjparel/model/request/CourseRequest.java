package com.enigmacamp.learnspringbootjparel.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseRequest {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotBlank(message = "{invalid.link.required}")
    private String link;

    @NotNull(message = "{invalid.coursetype.required")
    private CourseTypeRequest courseType;

    @NotNull(message = "Course info is required")
    private CourseInfoRequest courseInfo;
}
