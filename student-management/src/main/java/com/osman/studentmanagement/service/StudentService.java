package com.osman.studentmanagement.service;

import com.osman.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
}
