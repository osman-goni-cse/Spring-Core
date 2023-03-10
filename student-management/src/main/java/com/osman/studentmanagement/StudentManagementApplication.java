package com.osman.studentmanagement;

import com.osman.studentmanagement.entity.Student;
import com.osman.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Student student = new Student("Osman", " Goni", "osman@abc.com");
//        Student student1 = new Student("Farman", " Uddin", "farman@abc.com");
//        Student student2 = new Student("Osman", " Goni", "osman@abc.com");
//
//        studentRepository.save(student);
//        studentRepository.save(student1);
//        studentRepository.save(student2);
    }
}
