import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFile {
    private static final String FOLDER_PATH = "C:\\Users\\NelliGarbuz\\IdeaProjects\\LAB 3\\src"; // Specify your folder path here

    public static void displayFileInfo(String fileName) {
        File file = new File(FOLDER_PATH + File.separator + fileName);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;
                String line;

                while ((line = reader.readLine()) != null) {
                    // Count lines
                    lineCount++;

                    // Count words and characters in each line
                    String[] words = line.split("\\s+"); // Split by whitespace
                    wordCount += words.length;
                    charCount += line.length();
                }

                System.out.println("Line Count: " + lineCount);
                System.out.println("Word Count: " + wordCount);
                System.out.println("Character Count: " + charCount);
            } catch (IOException e) {
                System.out.println("Error reading text file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}
