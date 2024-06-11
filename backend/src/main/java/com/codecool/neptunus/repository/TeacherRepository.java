package com.codecool.neptunus.repository;

import com.codecool.neptunus.model.Course;
import com.codecool.neptunus.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT courses FROM Teacher WHERE id = :id")
    List<Course> getCourses(@Param("id") long id);

    Optional<Teacher> findByUsername(String username);
}
