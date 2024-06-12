package view;

import controller.StudentController;
import model.db.DataBase;
import model.impl.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private StudentController controller;

    public StudentView() {
        controller = new StudentController();
    }

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать студента");
            System.out.println("2 - найти студента по id");
            System.out.println("3 - Распечатать информацию о всех студентах.");
            System.out.println("4 - Выход.");
            switch (scanner.nextInt()) {
                case 1 -> createStudent();
                case 2 -> getById();
                case 3 -> getAllStudents();
                case 4 -> System.exit(2);
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
        Student student = controller.createStudent(name, lastName, groupId);
        System.out.println(student);
        return student;
    }

    private Student getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id студента: ");
        int id = scanner.nextInt();
        Student student = controller.getById(id);
        System.out.println(student);
        return student;
    }

    private List<Student> getAllStudents() {
        List<Student> students = controller.getAllStudents();
        System.out.println(students);
        return students;
    }
}
