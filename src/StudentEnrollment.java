import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class StudentEnrollment {
    private final Set<String> enrolledStudents;

    public StudentEnrollment() {
        enrolledStudents = new HashSet<String>();
    }

    public void addStudent(String student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(String student) {
        enrolledStudents.remove(student);
    }

    public boolean isEnrolled(String student) {
        return enrolledStudents.contains(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students:");
        for (String student : enrolledStudents) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentEnrollment enrollment = new StudentEnrollment();

        while (true) {
            System.out.println("-------------------------");
            System.out.println("Please select an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Check if a student is enrolled");
            System.out.println("4. Display enrolled students");
            System.out.println("5. Exit");
            System.out.println("-------------------------");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = input.nextLine();
                    enrollment.addStudent(name);
                    System.out.println(name + " added to enrollment.");
                    break;
                case 2:
                    System.out.println("Enter student name:");
                    String name2 = input.nextLine();
                    enrollment.removeStudent(name2);
                    System.out.println(name2 + " removed from enrollment.");
                    break;
                case 3:
                    System.out.println("Enter student name:");
                    String name3 = input.nextLine();
                    if (enrollment.isEnrolled(name3)) {
                        System.out.println(name3 + " is enrolled.");
                    } else {
                        System.out.println(name3 + " is not enrolled.");
                    }
                    break;
                case 4:
                    enrollment.displayEnrolledStudents();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}