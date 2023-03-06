package com.learnwithosman.dao;

import com.learnwithosman.entities.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(Student student) {
        String query = "INSERT INTO student(id, name, city) values(?, ?, ?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return result;
    }

    @Override
    public int update(Student student) {
        String query = "UPDATE student SET name=?, city=? WHERE id=?";
        int update = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return update;
    }

    @Override
    public int delete(int studentId) {
        String query = "DELETE FROM student WHERE id=?";
        int update = this.jdbcTemplate.update(query, studentId);
        return update;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "SELECT * FROM student WHERE id=?";
        RowMapper rowMapper = new RowMapperImpl();
        Student student = (Student) this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "SELECT * FROM student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }
}
