package domain.menu;
import domain.operations.FacultyOperations;

import java.util.Scanner;

public class FacultyMenu implements Menu {
    @Override
    public void displayMenu() {
        System.out.println("asf - Create and assign a student to faculty");
        System.out.println("gs - Graduate a student from a faculty");
        System.out.println("des - Display enrolled students");
        System.out.println("dg - Display graduates");
        System.out.println("bs - Tell or not if a student belongs to this faculty");
        System.out.println("b - Go back");
        System.out.println("q - Quit program");
    }
    @Override
    public void handleInput(Scanner scanner) {
        // Implement handleInput for general operations
        String choice = scanner.nextLine();


        switch (choice) {
            case "asf":
                FacultyOperations.createNewStudent(scanner);
                break;
            case "gs":
                FacultyOperations.graduateStudent(scanner);
                break;
            case "des":
                FacultyOperations.displayEnrolledStudents();
                break;
            case "dg":
                FacultyOperations.displayGraduates();
                break;
            case "bs":
                FacultyOperations.tellStudentFaculty(scanner);
                break;
            case "b":
                break;
            case "q":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}