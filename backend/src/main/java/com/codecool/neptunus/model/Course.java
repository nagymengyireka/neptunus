package com.codecool.neptunus.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String teacherName;
    @ManyToMany
    @JsonManagedReference
    private Set<Student> students;

    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Course course = (Course) object;
        return id == course.id && Objects.equals(name, course.name) && Objects.equals(teacherName, course.teacherName) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teacherName, students);
    }

    //    @Override
//    public String toString() {
//        return "Course{" +
//                "name='" + name + '\'' +
//                ", courseId=" + courseId +
//                ", teacherName='" + teacherName + '\'' +
//                ", students=" + students +
//                '}';
//    }
//
//    public boolean checkCourseId(int id){
//        return this.courseId == id;
//    }
}
