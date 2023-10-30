package handlers;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class StatusHandler {
    private static final String FOLDER_PATH = "C:\\Users\\NelliGarbuz\\Desktop\\oop\\Labs-OOP\\LAB3\\src\\files";
    private HashSet<String> lastSnapshotFiles;
    private long lastSnapshotTime;

    public StatusHandler() {
        lastSnapshotFiles = new HashSet<>();
        lastSnapshotTime = System.currentTimeMillis();
        populateLastSnapshotFiles();
    }

    private void populateLastSnapshotFiles() {
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
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleStatus() {
        try {
            HashSet<String> currentFiles = new HashSet<>();
            Path folderPath = Paths.get(FOLDER_PATH);

            Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    processFile(file, currentFiles);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // Handle the case where a file visit fails (optional)
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    processFile(dir, currentFiles);
                    return FileVisitResult.CONTINUE;
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

    private void processFile(Path path, HashSet<String> currentFiles) throws IOException {
        Path relativePath = Paths.get(FOLDER_PATH).relativize(path);
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
}
