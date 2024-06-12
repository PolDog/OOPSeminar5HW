package controller;

import model.impl.Student;
import service.StudentService;

import java.util.List;

public class StudentController {
    StudentService service;

    public StudentController() {
        service = new StudentService();
    }

    public Student createStudent(String name, String lastName, int idGroup) {
        return service.createStudent(name, lastName, idGroup);
    }

    public Student getById(int id) {
        Student student = null;
        try {
            student = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
}
