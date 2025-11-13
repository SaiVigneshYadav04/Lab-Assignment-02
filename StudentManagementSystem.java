import java.util.*;

abstract class Person {
    protected String name;
    protected String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract void displayInfo();
}

class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Student Profile ===");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Full Name: " + name);
        System.out.println("Email Address: " + email);
        System.out.println("Enrolled Course: " + course);
        System.out.println("Obtained Marks: " + marks);
        System.out.println("Current Grade: " + grade);
        System.out.println("=======================");
    }

    public void displayInfo(String researchArea) {
        displayInfo();
        System.out.println("Specialization: " + researchArea);
        System.out.println("Note: This version shows additional research info.");
        System.out.println("=======================");
    }

    public int getRollNo() { return rollNo; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }
    public void setEmail(String email) { this.email = email; }
}

interface RecordActions {
    void addStudent(Student student);
    void deleteStudent(int rollNo);
    void updateStudent(int rollNo, String course, double marks);
    Student searchStudent(int rollNo);
    void viewAllStudents();
}

class StudentManager implements RecordActions {
    private Map<Integer, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        if(studentMap.containsKey(student.getRollNo())) {
            System.out.println("Cannot add student: Roll number " + student.getRollNo() + " already exists.");
        } else {
            studentMap.put(student.getRollNo(), student);
            System.out.println("Student added successfully with Roll Number: " + student.getRollNo());
        }
    }

    @Override
    public void deleteStudent(int rollNo) {
        if(studentMap.remove(rollNo) != null) {
            System.out.println("Student with Roll Number " + rollNo + " has been removed.");
        } else {
            System.out.println("No student found with Roll Number " + rollNo + ".");
        }
    }

    @Override
    public void updateStudent(int rollNo, String course, double marks) {
        Student student = studentMap.get(rollNo);
        if(student != null) {
            student.setCourse(course);
            student.setMarks(marks);
            System.out.println("Student record for Roll Number " + rollNo + " updated successfully.");
        } else {
            System.out.println("No student found with Roll Number " + rollNo + ".");
        }
    }

    @Override
    public Student searchStudent(int rollNo) {
        return studentMap.get(rollNo);
    }

    @Override
    public void viewAllStudents() {
        if(studentMap.isEmpty()) {
            System.out.println("No student records available currently.");
        } else {
            for(Student student : studentMap.values()) {
                student.displayInfo();
            }
        }
    }
}

public class StudentManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch(choice) {
                case 1 -> addNewStudent();
                case 2 -> performUpdate();
                case 3 -> performDeletion();
                case 4 -> searchStudent();
                case 5 -> manager.viewAllStudents();
                case 6 -> System.out.println("Exiting Student Management System. Goodbye!");
                default -> System.out.println("Invalid choice. Please select again.");
            }
        } while(choice != 6);
    }

    private static void showMenu() {
        System.out.println("\nWelcome to the Student Management System!");
        System.out.println("1. Add a new student");
        System.out.println("2. Update student record");
        System.out.println("3. Delete a student");
        System.out.println("4. Search for a student");
        System.out.println("5. View all students");
        System.out.println("6. Exit");
        System.out.print("Enter your option: ");
    }

    private static void addNewStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();
        System.out.print("Enter Marks Obtained: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(rollNo, name, email, course, marks);
        manager.addStudent(student);
    }

    private static void performUpdate() {
        System.out.print("Enter Roll Number of student to update: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Course Name: ");
        String course = scanner.nextLine();
        System.out.print("Enter new Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        manager.updateStudent(rollNo, course, marks);
    }

    private static void performDeletion() {
        System.out.print("Enter Roll Number of student to delete: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        manager.deleteStudent(rollNo);
    }

    private static void searchStudent() {
        System.out.print("Enter Roll Number of student to search: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        Student student = manager.searchStudent(rollNo);
        if(student != null) {
            student.displayInfo();
        } else {
            System.out.println("No student found with Roll Number " + rollNo + ".");
        }
    }
}
