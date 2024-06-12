package model.impl;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private final List<Integer> groups;

    public Teacher(int id, String name, String lastName) {
        super(id, name, lastName);
        groups = new ArrayList<>();
    }

    public void addGroupId(int groupId) {   //надо будет перенести в контроллер
        groups.add(groupId);
    }
}
