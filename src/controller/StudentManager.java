package controller;

import model.Student;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private String name;
    private List<Student> studentList;

    public void addNewStudent(Student student) throws IOException {
        studentList.add(student);
        FileManager.writeFile(studentList);
    }

    public boolean editStudent(int index, Student student) throws IOException {
        studentList.set(index, student);
        FileManager.writeFile(studentList);
        return true;
    }

    public void deleteStudent(int index) {
        studentList.remove(index);
    }

    public void showAllStudent() {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public StudentManager(String name, List<Student> studentList) {
        this.name = name;
        this.studentList = studentList;
    }

    public StudentManager() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}