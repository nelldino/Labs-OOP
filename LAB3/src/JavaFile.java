import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaFile {
    private static final String FOLDER_PATH = "C:\\Users\\NelliGarbuz\\IdeaProjects\\LAB 3\\src"; // Specify your folder path here

    public static void displayFileInfo(String fileName) {
        File file = new File(FOLDER_PATH + File.separator + fileName);

        if (file.exists() && file.getName().endsWith(".java")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                int lineCount = 0;
                int classCount = 0;
                int methodCount = 0;

                String line;
                boolean insideMethod = false;

                // Regular expressions for class and method detection
                Pattern classPattern = Pattern.compile("\\bclass\\s+([a-zA-Z_$][a-zA-Z\\d_$]*)\\b");
                Pattern methodPattern = Pattern.compile("\\b(public|private|protected)?\\s+(static\\s+)?[a-zA-Z_$][a-zA-Z\\d_$]*\\s+([a-zA-Z_$][a-zA-Z\\d_$]*)\\s*\\([^)]*\\)\\s*\\{");

                while ((line = reader.readLine()) != null) {
                    lineCount++;

                    Matcher classMatcher = classPattern.matcher(line);
                    Matcher methodMatcher = methodPattern.matcher(line);

                    if (classMatcher.find()) {
                        classCount++;
                    }

                    if (methodMatcher.find()) {
                        if (!insideMethod) {
                            insideMethod = true;
                            methodCount++;
                        }
                    } else {
                        insideMethod = false;
                    }
                }

                System.out.println("Line Count: " + lineCount);
                System.out.println("Class Count: " + classCount);
                System.out.println("Method Count: " + methodCount);
            } catch (IOException e) {
                System.out.println("Error reading Java file: " + e.getMessage());
            }
        } else {
            System.out.println("Java file not found: " + fileName);
        }
    }
}
