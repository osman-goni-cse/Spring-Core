package com.learnwithosman.dao;

import com.learnwithosman.entities.Student;

import java.util.List;

public interface StudentDao {
    int create(Student student);
    int update(Student student);
    int delete(int studentId);
    Student getStudent(int studentId);

    List<Student> getAllStudents();

}
