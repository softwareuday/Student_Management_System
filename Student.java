import java.util.*;

public class Student {
    private int id;
    private String name;
    private int age;
    private String grade;
    private List<String> attendance; // Stores "Present" or "Absent" per day

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.attendance = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void markAttendance(String status) {
        attendance.add(status);
    }

    public List<String> getAttendance() {
        return attendance;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

