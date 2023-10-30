package handlers;

import watchers.SystemFile;

import java.util.Scanner;

public class CommandLineProcessor {
    private static final String FOLDER_PATH = "C:\\Users\\NelliGarbuz\\Desktop\\oop\\Labs-OOP\\LAB3\\src\\files";
    private CommitHandler commitHandler;
    private StatusHandler statusHandler;

    public CommandLineProcessor() {
        commitHandler = new CommitHandler();
        statusHandler = new StatusHandler();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Folder Monitoring System");
            System.out.println("1. commit");
            System.out.println("2. info all/ specific files");
            System.out.println("3. status");
            System.out.println("4. exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "commit":
                    commitHandler.handleCommit();
                    break;
                case "info all":
                    FileInfoPrinter fileInfoPrinter = new FileInfoPrinter();
                    FileInfoPrinter.printFileInfo(SystemFile.FOLDER_PATH);
                    break;
                case "info specific file":
                    SystemFile.GeneralInfo();;
                    break;
                case "status":
                    statusHandler.handleStatus();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
