package controller;

import model.impl.Teacher;
import service.TeacherService;

import java.util.List;

public class TeacherController {
    TeacherService service;

    public TeacherController() {
        service = new TeacherService();
    }

    public Teacher getById(int id) {
        Teacher teacher = null;
        try {
            teacher = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }
    public List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }
}
