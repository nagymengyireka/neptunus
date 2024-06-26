package com.codecool.neptunus.repository;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT courses FROM Student WHERE id = :id")
    List<Course> getCourses(@Param("id") Long id);

    Optional<Student> findByStudentId(String studentId);

    boolean existsByStudentId(String studentId);
}
