
import java.util.*;

public class StudentManagementSystem {
    private static HashMap<Integer, Student> studentMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String TEACHER_PASSWORD = "admin123";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Welcome to Student Management System =====");
            System.out.println("1. Teacher Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> teacherLogin();
                case 2 -> studentLogin();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void teacherLogin() {
        System.out.print("Enter Teacher Password: ");
        String pass = scanner.nextLine();
        if (TEACHER_PASSWORD.equals(pass)) {
            teacherMenu();
        } else {
            System.out.println("Incorrect password.");
        }
    }

    private static void teacherMenu() {
        while (true) {
            System.out.println("\n--- Teacher Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View All Students");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> markAttendance();
                case 3 -> viewAllStudents();
                case 4 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentMap.containsKey(id)) {
            System.out.println("Student already exists.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        studentMap.put(id, new Student(id, name, age, grade));
        System.out.println("Student added.");
    }

    private static void markAttendance() {
        if (studentMap.isEmpty()) {
            System.out.println("No students to mark.");
            return;
        }
        for (Student s : studentMap.values()) {
            System.out.print("Mark attendance for " + s.toString() + " (P/A): ");
            String input = scanner.nextLine().trim().toUpperCase();
            s.markAttendance(input.equals("P") ? "Present" : "Absent");
        }
        System.out.println("Attendance marked.");
    }

    private static void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records.");
        } else {
            for (Student s : studentMap.values()) {
                System.out.println(s);
            }
        }
    }

    private static void studentLogin() {
        System.out.print("Enter your Student ID: ");
        int id = scanner.nextInt();
        Student student = studentMap.get(id);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Welcome, " + student.toString());
            System.out.println("Attendance Record: " + student.getAttendance());
        }
    }
}
