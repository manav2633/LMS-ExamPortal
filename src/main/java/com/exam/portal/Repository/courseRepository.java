package com.exam.portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.portal.Model.course;

public interface courseRepository extends JpaRepository<course, Integer> {

     @Query("SELECT DISTINCT c.courseCategory FROM course c")
    List<String> findDistinctCourseCategory();

    List<course> findByCourseCategory(String category);

  

}
