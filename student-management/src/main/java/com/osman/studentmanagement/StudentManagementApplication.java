package com.osman.studentmanagement;

import com.osman.studentmanagement.entity.Student;
import com.osman.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

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
//    @Bean
//    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurity sec) {
//        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        templateEngine.addDialect(sec); // Enable use of "sec"
//        return templateEngine;
//    }
}
