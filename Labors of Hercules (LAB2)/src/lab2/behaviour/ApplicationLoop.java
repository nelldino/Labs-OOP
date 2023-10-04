package src.lab2.behaviour;

import src.lab2.models.Faculty;
import src.lab2.models.StudyField;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationLoop {
    
    private static List<Faculty> faculties = new ArrayList<>();

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        ApplicationLoop app = new ApplicationLoop();
        app.startMenu();

        while (true) {
    
            System.out. println("g - general operations");
            System.out. println("f - faculty operations");
            System.out. println("q - quit program");

            String choice = scanner.nextLine();

            switch (choice) {
                case "g":
                    app.generalOperationsMenu();
                    break;
                case "f":
                    searchFacultyForStudent(scanner);
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

    private void startMenu() {
        System.out.println("Welcome to TUM's student management system!");
        System.out.println("What do you want to do?");
    }

        private void generalOperationsMenu() {
        System.out.println("nf - Create a new faculty");
        System.out.println("sf - Search what faculty a student belongs to by a unique identifier (by email)");
        System.out.println("df - Display university faculties");
        System.out.println("dff - Display all faculties belonging to a field");
        System.out.println("b - Go back");
        System.out.println("q - Quit program");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "nf":
                System.out.println("nf/<faculty name>/<faculty abbreviation/<field> - create faculty command");
                createNewFaculty(scanner);
                break;
            case "sf":
                System.out.println("sf/<student email> - search the faculty a student belongs to command");
                searchFacultyForStudent(scanner);
                break;
            case "df":
                displayAllFaculties();
                break;
            case "dff":
                System.out.println("dff/<field> -display all faculties belonging to a field command ");
                displayFacultiesByField(scanner);
                break;
            case "b":
                startMenu();
                break;
            case "q":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void createNewFaculty(Scanner scanner) {
        System.out.print("Enter faculty name: ");
        String name = scanner.nextLine();
        System.out.print("Enter faculty abbreviations: ");
        String abbrev = scanner.nextLine();
        System.out.println("Choose study fields:");
        displayStudyFields();
        System.out.print("Enter study field (by name): ");
        String fieldInput = scanner.nextLine();
        StudyField studyField = StudyField.valueOf(fieldInput.toUpperCase());

        Faculty newFaculty = new Faculty(name, abbrev, studyField);
        faculties.add(newFaculty);
        System.out.println("New faculty created successfully!");
    }

    private static void searchFacultyForStudent(Scanner scanner) {
        System.out.print("Enter student email: ");
        String studentEmail = scanner.nextLine();
        boolean found = false;
    
        for (Faculty faculty : faculties) {
            // Assuming each faculty has a list of students with their email addresses
            List<String> studentEmails = faculty.getStudentEmails();
    
            if (studentEmails.contains(studentEmail)) {
                System.out.println("Student with email " + studentEmail + " belongs to the faculty: " + faculty.getName());
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Student with email " + studentEmail + " not found in any faculty.");
        }
    }
    
    private static void displayAllFaculties() {
        System.out.println("List of all faculties:");
        for (Faculty faculty : faculties) {
            System.out.println(faculty);
        }
    }

    private static void displayFacultiesByField(Scanner scanner) {
        System.out.println("Available study fields:");
        displayStudyFields();

        System.out.print("Enter study field (by name): ");
        String fieldInput = scanner.nextLine();
        StudyField studyField = StudyField.valueOf(fieldInput.toUpperCase());

        System.out.println("Faculties belonging to " + studyField + " field:");
        for (Faculty faculty : faculties) {
            if (faculty.getStudyField() == studyField) {
                System.out.println(faculty);
            }
        }
    }

    private static void displayStudyFields() {
        for (StudyField field : StudyField.values()) {
            System.out.println(field.name());
        }
    }
}
