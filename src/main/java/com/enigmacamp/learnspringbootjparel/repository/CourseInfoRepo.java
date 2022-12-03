package com.enigmacamp.learnspringbootjparel.repository;

import com.enigmacamp.learnspringbootjparel.model.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInfoRepo extends JpaRepository<CourseInfo, String> {
}
