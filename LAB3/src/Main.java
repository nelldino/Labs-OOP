import handlers.CommandLineProcessor;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Path folderPath = Paths.get("C:\\Users\\NelliGarbuz\\Desktop\\oop\\Labs-OOP\\LAB3\\src\\files");

        try {
            FileChangeDetector fileChangeDetector = new FileChangeDetector(folderPath);
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(fileChangeDetector::startMonitoring, 0, 5, TimeUnit.SECONDS);

            CommandLineProcessor processor = new CommandLineProcessor();
            processor.start();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    fileChangeDetector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
