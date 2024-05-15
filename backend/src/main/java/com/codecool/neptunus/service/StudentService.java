package com.codecool.neptunus.service;

import com.codecool.neptunus.model.Student;
import com.codecool.neptunus.service.dao.MemoryStudentDAO;
import com.codecool.neptunus.service.dao.StudentDAO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private MemoryStudentDAO memoryStudentDAO;

    public StudentService(MemoryStudentDAO memoryStudentDAO) {
        this.memoryStudentDAO = memoryStudentDAO;
    }

    public String addStudent(Student student){
        return memoryStudentDAO.addStudent(student);
    }

    public String removeStudent(String studentId){
        return memoryStudentDAO.removeStudent(studentId);
    }
    public Student getStudent(String studentId){
        return memoryStudentDAO.getStudent(studentId); //TODO FELJEBB VINNI CONTROLLERBE
    }


}
