package watchers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramFile extends FileItem {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public ProgramFile(String fileName) {
        super(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern classPattern = Pattern.compile("(public|private|protected)?\\s+class\\s+(\\w+)");
            Pattern methodPattern = Pattern.compile("(public|private|protected)?\\s+(\\w+)\\s+(\\w+)\\s*\\(.*\\)\\s*\\{");
            boolean insideMultiLineComment = false;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (line.trim().startsWith("/*")) {
                    insideMultiLineComment = true;
                }
                if (insideMultiLineComment) {
                    if (line.trim().endsWith("*/")) {
                        insideMultiLineComment = false;
                    }
                    continue;
                }
                if (line.trim().startsWith("//")) {
                    continue;
                }
                Matcher classMatcher = classPattern.matcher(line);
                while (classMatcher.find()) {
                    classCount++;
                }
                Matcher methodMatcher = methodPattern.matcher(line);
                while (methodMatcher.find()) {
                    methodCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getClassCount() {
        return classCount;
    }

    public int getMethodCount() {
        return methodCount;
    }
    public void printFileInfo() {
        System.out.println("Line Count: " + getLineCount());
        System.out.println("Class Count: " + getClassCount());
        System.out.println("Method Count: " + getMethodCount());
    }
}
