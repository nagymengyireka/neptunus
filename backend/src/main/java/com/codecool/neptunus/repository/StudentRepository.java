package com.codecool.neptunus.repository;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT courses FROM Student WHERE Student.id = :id")
    List<Course> getCourses(@Param("id") Long id);
}
