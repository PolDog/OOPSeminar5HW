package controller;

import model.StudyGroup;
import model.impl.Student;
import model.impl.Teacher;
import service.StudyGroupService;

import java.util.List;

public class StudyGroupController {
    StudyGroupService service = new StudyGroupService();

    public StudyGroup createGroup(Teacher teacher, List<Student> students) {
        try {
            return service.createGroup(teacher, students);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void printGroup(StudyGroup group) {
        if (group != null) {
            service.printGroup(group);
        }
    }

    public List<StudyGroup> getAllGroups() {
        return service.getAllGroups();
    }

    public StudyGroup getGroupById(int id) {
        StudyGroup group = null;
        try {
            group = service.getGroupById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return group;
    }
}
