package com.codecool.neptunus.repository;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT students FROM Course WHERE id = :id")
    Set<Student> getStudents(@Param("id") Long id);
}
