package com.example.SpringBootProject.Repository;

import com.example.SpringBootProject.Module.Course_details;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Course_detailsRepo extends JpaRepository<Course_details, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE course_details  SET course_name = :course_name, duration = :duration, course_cost = :course_cost WHERE id = :id", nativeQuery = true)
    void updateCourse(
            @Param("id") int id,
            @Param("course_name") String course_name,
            @Param("duration") String duration,
            @Param("course_cost") Long course_cost
    );
}