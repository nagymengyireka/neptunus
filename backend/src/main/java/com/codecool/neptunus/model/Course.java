package com.codecool.neptunus.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private Teacher teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
