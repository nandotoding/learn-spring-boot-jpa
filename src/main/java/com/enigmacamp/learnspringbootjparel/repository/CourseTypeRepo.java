package com.enigmacamp.learnspringbootjparel.repository;

import com.enigmacamp.learnspringbootjparel.model.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTypeRepo extends JpaRepository<CourseType, String> {
}
