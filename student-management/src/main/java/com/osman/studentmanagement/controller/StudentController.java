package com.osman.studentmanagement.controller;

import com.osman.studentmanagement.entity.Student;
import com.osman.studentmanagement.service.StudentService;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String addNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveNewStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/update/{studentId}")
    public String updateStudent(@PathVariable Long studentId,
                                Model model) {
        Student existingStudent = studentService.getStudentById(studentId);
        model.addAttribute("student", existingStudent);

        return "update_student_form";
    }
    @PostMapping("/students/update/{studentId}")
    public String saveUpdatedStudent(@PathVariable Long studentId,
                                     @ModelAttribute Student student) {

        Student existingStudent = studentService.getStudentById(studentId);

        existingStudent.setId(studentId);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
