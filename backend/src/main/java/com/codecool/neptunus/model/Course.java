package com.codecool.neptunus.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private final String name;
    private final int courseId;
    private final String teacherName;
    private final Set<Student> students;

    public Course(String name, int courseId, String teacherName) {
        this.name = name;
        this.courseId = courseId;
        this.teacherName = teacherName;
        this.students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTeacherName() {
        return teacherName;
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
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseId=" + courseId +
                ", teacherName='" + teacherName + '\'' +
                ", students=" + students +
                '}';
    }
}
