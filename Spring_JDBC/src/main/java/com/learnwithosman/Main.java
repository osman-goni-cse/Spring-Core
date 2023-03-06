package com.learnwithosman;

import com.learnwithosman.dao.StudentDao;
import com.learnwithosman.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Spring JDBC!");
//        Below code is for when we use xml based configuration
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
//        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        String query = "INSERT INTO student(id, name, city) values(?, ?, ?)";
//
//        int result = jdbcTemplate.update(query, 1002, "Lokman", "2 No. Gate");
//
//        System.out.println("Number of Rows : "+ result);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);

        Student student = new Student();

//        student.setId(99);

//        int result = studentDao.delete(99);
        Student student1 = studentDao.getStudent(1001);
        System.out.println("Students : " + student1);

        List<Student> students = studentDao.getAllStudents();
        System.out.println(students);
    }
}