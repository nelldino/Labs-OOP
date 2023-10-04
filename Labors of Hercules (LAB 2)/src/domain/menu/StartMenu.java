package domain.menu;
import java.util.Scanner;

public class StartMenu implements Menu {
    @Override
    public void displayMenu() {
        System.out.println("Welcome to TUM's student management system!");
        System.out.println("What do you want to do?");
        System.out.println("g - general operations");
        System.out.println("f - faculty operations");
        System.out.println("q - quit program");
    }

    @Override
    public void handleInput(Scanner scanner) {
        String choice = scanner.nextLine();
        switch (choice) {
            case "g":
                Menu generalMenu = new GeneralMenu();
                generalMenu.displayMenu();
                generalMenu.handleInput(scanner);
                break;
            case "f":
                Menu facultyMenu = new FacultyMenu();
                facultyMenu.displayMenu();
                facultyMenu.handleInput(scanner);
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
