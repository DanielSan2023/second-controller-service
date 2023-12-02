package com.engeto.controller;

import com.engeto.model.Student;
import com.engeto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired // Dependency injection - injekt class Student Service try konstructor
    private StudentService studentService; // jeden objekt pre  celu triedu



    @GetMapping("/students")
    public List<Student> getStudents() {
        // 1.return studentService.createAndSendStudents();
//2.       List<Student> students = studentService.returnStudents();
//2.        return students;
      return studentService.returnStudents();

    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        Student student = new Student();
        student.setName("Daniel");
        student.setSurname("San");
        student.setAge(39);
        student.setId(id);
        return student;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        //student.getName;
        studentService.createNewStudent(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
       studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
       studentService.updateStudent(id, student);
    }

    @GetMapping("/students/create") //@PostMapping instead @GetMapping
    public void createDefaultStudents() {
        studentService.createDefaultStudents();
    }
}







