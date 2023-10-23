import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FolderMonitor {

    private static long lastSnapshotTime;
    private static final String folderPath = "C:\\Users\\NelliGarbuz\\IdeaProjects\\LAB 3\\src"; // Specify your folder path here

    public static void main(String[] args) {
        lastSnapshotTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Folder Monitoring System");
            System.out.println("1. Commit changes");
            System.out.println("2. File Information");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    commitChanges();
                    break;
                case 2:
                    scanner.nextLine(); // Consume the newline character left after previous nextInt()
                    System.out.print("Enter filename: ");
                    String fileName = scanner.nextLine();
                    displayFileInfo(fileName);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void commitChanges() {
        lastSnapshotTime = System.currentTimeMillis();
        System.out.println("Changes committed. Snapshot time updated to: " + getCurrentTime());
    }

    private static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(lastSnapshotTime);
        return sdf.format(resultDate);
    }


    private static void displayFileInfo(String fileName) {
        if (fileName.endsWith(".txt")) {
            TextFile.displayFileInfo(fileName);
        } else if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
            ImageFile.displayFileInfo(fileName);
        } else if (fileName.endsWith(".java")) {
            JavaFile.displayFileInfo(fileName);
        } else if (fileName.endsWith(".py")) {
            PythonFile.displayFileInfo(fileName);
        } else {
            System.out.println("Unsupported file type: " + fileName);
        }
    }
}