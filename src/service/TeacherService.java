package service;

import model.db.DataBase;
import model.impl.Teacher;

import java.util.List;

public class TeacherService {
    public Teacher getById(int id) throws Exception {
        Teacher teacher = DataBase.teachersDB
                .stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(null);

        if (teacher == null) {
            throw new Exception("Преподаватель не найден");
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return DataBase.teachersDB;
    }
}
