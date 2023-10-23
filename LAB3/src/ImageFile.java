import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile {
    private static final String FOLDER_PATH = "C:\\Users\\NelliGarbuz\\IdeaProjects\\LAB 3\\src";
    public static void displayFileInfo(String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            if (image != null) {
                int width = image.getWidth();
                int height = image.getHeight();
                System.out.println("Image Size: " + width + "x" + height);
            } else {
                System.out.println("Failed to read image: " + fileName);
            }
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
        }
    }
}
