package service;

// в презентации называется дата сервис

import model.db.DataBase;
import model.impl.Student;

import java.util.List;

public class StudentService {
    public Student createStudent(String name, String lastName, int idGroup) {
        int id;
        int size = DataBase.studentsDB.size();
        if (size == 0) {
            id = 1;
        } else {
            id = size + 1;
        }
        Student student = new Student(id, name, lastName, idGroup);
        DataBase.studentsDB.add(student);
        return student;
    }

    public Student getById(int id) throws Exception {
        Student student = DataBase.studentsDB
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(null);

        if (student == null) {
            throw new Exception("Студент не найден");
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return DataBase.studentsDB;
    }
}
