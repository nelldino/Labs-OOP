package watchers;

import java.io.File;

public abstract class FileItem {
    protected String fileName;
    protected String extension;
    public abstract void printFileInfo();
    public FileItem(String fileName) {
        this.fileName = fileName;
        File file = new File(fileName);
        this.extension = getFileExtension(file);
    }

    private String getFileExtension(File file) {
        String extension = "";
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            extension = fileName.substring(dotIndex + 1);
        }
        return extension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
    }
}
