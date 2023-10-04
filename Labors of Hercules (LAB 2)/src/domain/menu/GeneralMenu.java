package domain.menu;
import domain.operations.GeneralOperations;

import java.util.Scanner;

public class GeneralMenu implements Menu {
    @Override
    public void displayMenu() {
        System.out.println("nf - Create a new faculty");
        System.out.println("sf - Search what faculty a student belongs to by a unique identifier (by email)");
        System.out.println("df - Display university faculties");
        System.out.println("dff - Display all faculties belonging to a field");
        System.out.println("b - Go back");
        System.out.println("q - Quit program");
    }

    @Override
    public void handleInput(Scanner scanner) {
        // Implement handleInput for general operations
        String choice = scanner.nextLine();


        switch (choice) {
            case "nf":
                GeneralOperations.createNewFaculty(scanner);
                break;
            case "sf":
                GeneralOperations.searchFacultyForStudent(scanner);
                break;
            case "df":
                GeneralOperations.displayAllFaculties();
                break;
            case "dff":
                GeneralOperations.displayFacultiesByField(scanner);
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