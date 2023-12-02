package com.engeto.service;

import com.engeto.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    private List<Student> students = new ArrayList<>();

    public void createDefaultStudents() {
        Student student1 = new Student();
        student1.setName("Daniel");
        student1.setSurname("San");
        student1.setAge(39);
        student1.setId(1L);

        Student student2 = new Student();
        student2.setName("Bruce");
        student2.setSurname("Lee");
        student2.setAge(59);
        student2.setId(2L);

        students.add(student1);
        students.add(student2);

    }

    public List<Student> returnStudents() {
        return students;
    }


    public void createNewStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void updateStudent(Long id, Student student) {
        students.forEach(student1 -> {
            if (student1.getId().equals(id)) {
                student1.setName(student.getName());
                student1.setSurname(student.getSurname());
                student1.setAge(student.getAge());
            }
        });
    }
}
