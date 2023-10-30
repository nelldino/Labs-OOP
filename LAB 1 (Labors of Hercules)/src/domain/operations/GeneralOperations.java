package domain.operations;

import domain.models.Faculty;
import domain.models.StudyField;
import domain.models.FacultyManager;

import java.util.Scanner;

public class GeneralOperations {
    public static FacultyManager facultyManager;

    public static void createNewFaculty(Scanner scanner) {
        System.out.print("Enter faculty name: ");
        String name = scanner.nextLine();
        System.out.print("Enter faculty abbreviations: ");
        String abbrev = scanner.nextLine();
        System.out.println("Choose study fields:");
        displayStudyFields();
        System.out.print("Enter study field (by name): ");
        String fieldInput = scanner.nextLine();
        StudyField studyField = StudyField.valueOf(fieldInput.toUpperCase());

        facultyManager.createNewFaculty(name, abbrev, studyField);
        System.out.println("New faculty created successfully!");
    }

    public static void searchFacultyForStudent(Scanner scanner) {
        System.out.print("Enter student email: ");
        String studentEmail = scanner.nextLine();
        Faculty foundFaculty = facultyManager.findFacultyByStudentEmail(studentEmail);

        if (foundFaculty != null) {
            System.out.println("Student with email " + studentEmail + " belongs to the faculty: " + foundFaculty.getName());
        } else {
            System.out.println("Student with email " + studentEmail + " not found in any faculty.");
        }
    }

    public static void displayAllFaculties() {
        System.out.println("List of all faculties:");
        for (Faculty faculty : facultyManager.getFaculties()) {
            System.out.println(faculty);
        }
    }

    public static void displayFacultiesByField(Scanner scanner) {
        System.out.println("Available study fields:");
        displayStudyFields();

        System.out.print("Enter study field (by name): ");
        String fieldInput = scanner.nextLine();
        StudyField studyField = StudyField.valueOf(fieldInput.toUpperCase());

        System.out.println("Faculties belonging to " + studyField + " field:");
        for (Faculty faculty : facultyManager.getFaculties()) {
            if (faculty.getStudyField() == studyField) {
                System.out.println(faculty);
            }
        }
    }

    public static void displayStudyFields() {
        for (StudyField field : StudyField.values()) {
            System.out.println(field.name());
        }
    }
}
