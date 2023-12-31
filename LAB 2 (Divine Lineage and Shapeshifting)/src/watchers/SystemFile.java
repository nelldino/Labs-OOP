package watchers;

import java.util.Scanner;
import java.io.File;

public class SystemFile {
    public static final String FOLDER_PATH = "C:\\Users\\NelliGarbuz\\Desktop\\oop\\Labs-OOP\\LAB 2 (Divine Lineage and Shapeshifting)\\src\\files";

    public static void GeneralInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = FOLDER_PATH + File.separator + scanner.nextLine();
        FileItem file;
        if (fileName.endsWith(".txt")) {
            file = new TextFile(fileName);
        } else if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
            file = new ImageFile(fileName);
        } else if (fileName.endsWith(".java") || fileName.endsWith(".py")){
            file = new ProgramFile(fileName);
        } else {
            System.out.println("Unsupported file type.");
            return;
        }
        System.out.println("Extension: " + file.getExtension());

        if (file instanceof TextFile) {
            TextFile textFile = (TextFile) file;
            file.printFileInfo();
        } else if (file instanceof ImageFile) {
            ImageFile imageFile = (ImageFile) file;
            file.printFileInfo();
        } else if (file instanceof ProgramFile) {
            ProgramFile programFile = (ProgramFile) file;
            file.printFileInfo();

        }

    }
}
