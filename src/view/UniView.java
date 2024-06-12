package view;

import controller.StudentController;
import controller.StudyGroupController;
import controller.TeacherController;
import model.StudyGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;

import java.util.List;
import java.util.Scanner;

public class UniView {
    private StudentController studentController;
    private StudyGroupController groupController;
    private TeacherController teacherController;

    public UniView() {
        studentController = new StudentController();
        groupController = new StudyGroupController();
        teacherController = new TeacherController();
    }

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать студента");
            System.out.println("2 - найти студента по id");
            System.out.println("3 - Распечатать информацию о всех студентах.");
            System.out.println("4 - Объеденить студентов в группу");
            System.out.println("5 - Распечатать группу");
            System.out.println("0 - Выход.");
            switch (scanner.nextInt()) {
                case 1 -> createStudent();
                case 2 -> getById();
                case 3 -> getAllStudents();
                case 4 -> createGroup();
                case 5 -> printGroup();
                case 0 -> System.exit(2);
                default -> {
                    System.out.println("Операция не поддерживается");
                }
            }
        }
    }

    private Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите Фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите Номер группы: ");
        int groupId = scanner.nextInt();
        Student student = studentController.createStudent(name, lastName, groupId);
        System.out.println(student);
        return student;
    }

    private Student getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id студента: ");
        int id = scanner.nextInt();
        Student student = studentController.getById(id);
        System.out.println(student);
        return student;
    }

    private List<Student> getAllStudents() {
        List<Student> students = studentController.getAllStudents();
        System.out.println(students);
        return students;
    }

    private StudyGroup createGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(teacherController.getAllTeachers());
        System.out.println("Введите id преподавателя: ");
        int id = scanner.nextInt();
        Teacher teacher = teacherController.getById(id);
        StudyGroup group = groupController.createGroup(teacher, studentController.getAllStudents());
        System.out.println("Группа создана!");
        return group;
    }

    private void printGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(groupController.getAllGroups());
        System.out.println("Введите id группы: ");
        int id = scanner.nextInt();
        StudyGroup group = groupController.getGroupById(id);
        groupController.printGroup(group);
    }
}
