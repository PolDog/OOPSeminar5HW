package service;

import model.StudyGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;

import java.util.List;

public class StudyGroupService {


    public StudyGroup createGroup(Teacher teacher, List<Student> students) throws Exception {
        if (teacher == null) {
            throw new Exception("Группу без преподавателя не создать");
        }
        int id;
        int size = DataBase.groupsDB.size();
        if (size == 0) {
            id = 1;
        } else {
            id = size + 1;
        }
        StudyGroup group = new StudyGroup(id, teacher, students);
        DataBase.groupsDB.add(group);
        return group;
    }

    public void printGroup(StudyGroup group) {
        System.out.println(group);
    }

    public List<StudyGroup> getAllGroups() {
        return DataBase.groupsDB;
    }

    public StudyGroup getGroupById(int id) throws Exception {
        StudyGroup group = DataBase.groupsDB
                .stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(null);

        if (group == null) {
            throw new Exception("группа не найден");
        }
        return group;
    }
}
