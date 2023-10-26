package watchers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFile extends FileItem {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextFile(String fileName) {
        super(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                charCount += line.length();
                wordCount += line.split("\\s+").length;
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }
    @Override
    public void printFileInfo() {
        System.out.println("Line Count: " + getLineCount());
        System.out.println("Word Count: " + getWordCount());
        System.out.println("Char Count: " + getCharCount());
    }
}
