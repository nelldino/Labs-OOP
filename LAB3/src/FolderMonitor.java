import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;

public class FolderMonitor {
    private static final String FOLDER_PATH = "C:\\Users\\NelliGarbuz\\Desktop\\labs-oop\\Labs-OOP\\LAB3\\src\\files";
    private static long lastSnapshotTime = System.currentTimeMillis();
    private static HashSet<String> lastSnapshotFiles = new HashSet<>();

    public static void main(String[] args) {
        try {
            Path folderPath = Paths.get(FOLDER_PATH);
            Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path relativePath = folderPath.relativize(file);
                    String fileName = relativePath.toString().toLowerCase();
                    lastSnapshotFiles.add(fileName);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // Handle the case where a file visit fails (optional)
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Path relativePath = folderPath.relativize(dir);
                    String dirName = relativePath.toString().toLowerCase();
                    lastSnapshotFiles.add(dirName);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Folder Monitoring System");
            System.out.println("1. commit");
            System.out.println("2. info all/specific file");
            System.out.println("3. status");
            System.out.println("4. exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "commit":
                    commitChanges();
                    break;
                case "info all":
                    FileInfoPrinter fileInfoPrinter = new FileInfoPrinter();
                    FileInfoPrinter.printFileInfo(FOLDER_PATH);
                    break;
                case "info specific file":
                    SystemFile.GeneralInfo();
                    break;
                case "status":
                    checkFileStatus();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void commitChanges() {
        lastSnapshotTime = System.currentTimeMillis();
        System.out.println("Created snapshot at: " + getCurrentTime());
    }

    private static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(lastSnapshotTime);
        return sdf.format(resultDate);
    }

    private static void checkFileStatus() {
        try {
            HashSet<String> currentFiles = new HashSet<>();
            Path folderPath = Paths.get(FOLDER_PATH);

            Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    processFile(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // Handle the case where a file visit fails (optional)
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    processFile(dir);
                    return FileVisitResult.CONTINUE;
                }

                private void processFile(Path path) throws IOException {
                    Path relativePath = folderPath.relativize(path);
                    String fileName = relativePath.toString().toLowerCase();
                    if (fileName.isEmpty()) {
                        return;
                    }
                    long lastModifiedMillis = Files.getLastModifiedTime(path).toMillis();

                    if (!lastSnapshotFiles.contains(fileName)) {
                        System.out.println(fileName + " - New File");
                    } else if (lastModifiedMillis > lastSnapshotTime) {
                        System.out.println(fileName + " - Changed");
                    } else {
                        System.out.println(fileName + " - Not Changed");
                    }
                    currentFiles.add(fileName);
                }
            });

            // Detect deleted files or directories
            for (String fileName : lastSnapshotFiles) {
                if (!currentFiles.contains(fileName.toLowerCase())) {
                    System.out.println(fileName + " - Deleted");
                }
            }

            lastSnapshotFiles = currentFiles;
            lastSnapshotTime = System.currentTimeMillis(); // Update the last snapshot time
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}