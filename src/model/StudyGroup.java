package model;

import model.impl.Student;
import model.impl.Teacher;

import java.util.List;

public class StudyGroup {
    int id;
    Teacher teacher;
    List<Student> students;

    public StudyGroup(int id, Teacher teacher, List<Student> students) {
        this.id = id;
        this.teacher = teacher;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudyGroup " + "id=" + id + ", " + teacher + ", " + students;
    }
}
