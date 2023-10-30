package watchers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramFile extends FileItem {
    private int lineCount;
    private int classCount;
    private int methodCount;



    public ProgramFile(String filename) {
        super(filename);
        parseProgramFile();
    }
            private void parseProgramFile() {
                File file = new File(fileName);
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lineCount++;

                        Pattern classPattern, methodPattern;
                        Matcher classMatcher, methodMatcher;

                        if (extension.equals("py")) {
                            classPattern = Pattern.compile("^\\s*class\\s+(\\w+)[\\s\\(]*(\\(.*\\))?:");
                            methodPattern = Pattern.compile("^def\\s+\\w+\\(.*\\):");
                        } else if (extension.equals("java")) {
                            classPattern = Pattern.compile("\\bclass\\b");
                            methodPattern = Pattern.compile("^(public|private|protected|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+[\\w_]+\\(.*\\)\\s*\\{?$");
                        } else {
                            continue;
                        }

                        classMatcher = classPattern.matcher(line.trim());
                        methodMatcher = methodPattern.matcher(line.trim());
                        if (classMatcher.find())
                            classCount++;
                        if (methodMatcher.find())
                            methodCount++;
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
    @Override
    public void printFileInfo() {
        System.out.println("Line Count: " + getLineCount());
        System.out.println("Class Count: " + getClassCount());
        System.out.println("Method Count: " + getMethodCount());
    }
}
