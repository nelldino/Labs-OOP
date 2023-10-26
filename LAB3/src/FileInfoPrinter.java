import java.nio.file.*;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileInfoPrinter {

    public static void printFileInfo(String folderPath) {
        Path dir = Paths.get(folderPath);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    String prettyExtension = getPrettyExtension(file);
                    String createdTime = dateFormat.format(new Date(attrs.creationTime().toMillis()));
                    String updatedTime = dateFormat.format(new Date(attrs.lastModifiedTime().toMillis()));

                    System.out.println("File Name: " + file.getFileName());
                    System.out.println("Pretty Extension: " + prettyExtension);
                    System.out.println("Created Time: " + createdTime);
                    System.out.println("Updated Time: " + updatedTime);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPrettyExtension(Path file) {
        String fileName = file.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toUpperCase();
        }
        return "No Extension";
    }
}
