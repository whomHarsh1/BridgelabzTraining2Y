
import java.util.Scanner;

class Student {

    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class Main {

    static Student head = null;
    static Scanner sc = new Scanner(System.in);

    // 1. Insert at beginning
    static void insertBeginning() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        String grade = sc.next();

        Student newNode = new Student(roll, name, age, grade);

        newNode.next = head;
        head = newNode;

        System.out.println("Student added at beginning.");
    }

    // 2. Insert at end
    static void insertEnd() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        String grade = sc.next();

        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student added at end.");
    }

    // 3. Insert at specific position
    static void insertPosition() {

        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        String grade = sc.next();

        Student newNode = new Student(roll, name, age, grade);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Student added successfully.");
            return;
        }

        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Student added successfully.");
    }

    // 4. Delete student by Roll Number
    static void deleteStudent() {

        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == roll) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.rollNo != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    // 5. Search student by Roll Number
    static void searchStudent() {

        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {

            if (temp.rollNo == roll) {
                System.out.println("Student Found!");
                System.out.println("Roll Number: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // 6. Display all students
    static void displayStudents() {

        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Student temp = head;

        System.out.println("\n----- Student Records -----");

        while (temp != null) {

            System.out.println("Roll Number: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            System.out.println("---------------------------");

            temp = temp.next;
        }
    }

    // 7. Update student grade
    static void updateGrade() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {

            if (temp.rollNo == roll) {

                System.out.print("Enter New Grade: ");
                temp.grade = sc.next();

                System.out.println("Grade updated successfully.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT RECORD MANAGEMENT =====");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Specific Position");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Display All Students");
            System.out.println("7. Update Student Grade");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertBeginning();
                    break;

                case 2:
                    insertEnd();
                    break;

                case 3:
                    insertPosition();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:
                    displayStudents();
                    break;

                case 7:
                    updateGrade();
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}