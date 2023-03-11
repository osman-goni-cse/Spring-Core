package com.osman.studentmanagement.service;

import com.osman.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long studentId);
}
