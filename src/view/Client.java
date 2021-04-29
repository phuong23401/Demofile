package view;

import controller.StudentManager;
import model.Student;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static List<Student> c0221i1 = new ArrayList<>();
    private static final StudentManager MANAGER = new StudentManager("Kieu Anh xinh", c0221i1);
    private static final Student STUDENT = newStudent();

    public static void main(String[] args) {
        while (true) {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÍ SINH VIÊN-----");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Ghi vào file");
            System.out.println("6. Đọc từ file");
            System.out.println("0. Thoát");
            System.out.println("Mời chọn chức năng: ");

            int choose = Integer.parseInt(SCANNER.nextLine());
            switch (choose) {
                case 1:
                    MANAGER.showAllStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    writeFile();
                    break;
                case 6:
                    readFile();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời nhập chức năng trong menu!");
                    break;
            }
        }
    }

    private static void addStudent() {
        try {
            MANAGER.addNewStudent(STUDENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editStudent() {
        try {
            MANAGER.editStudent(inputId(), STUDENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent() {
        try {
            MANAGER.deleteStudent(inputId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            FileManager.writeFile(c0221i1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try {
            c0221i1 = FileManager.readFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Student newStudent() {
        int id = inputId();
        String name = inputName();
        String add = inputAddress();

        return new Student(id, name, add);
    }

    private static String inputAddress() {
        System.out.print("Moi ban nhap dia chi: ");
        return SCANNER.nextLine();
    }

    private static String inputName() {
        System.out.print("Moi ban nhap ten: ");
        return SCANNER.nextLine();
    }

    private static int inputId() {
        System.out.print("Moi ban nhap Id: ");
        return Integer.parseInt(SCANNER.nextLine());
    }
}