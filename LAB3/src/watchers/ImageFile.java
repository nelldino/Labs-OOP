package watchers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile extends FileItem {
    private int width;
    private int height;

    public ImageFile(String fileName) {
        super(fileName);
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            this.width = image.getWidth();
            this.height = image.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    @Override
    public void printFileInfo() {
        System.out.println("Width: " + getWidth());
        System.out.println("Height: " + getHeight());
    }
}
