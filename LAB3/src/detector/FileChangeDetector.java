package detector;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class FileChangeDetector {

    private final Path folderPath;
    private WatchService watchService;

    public FileChangeDetector(Path folderPath) throws IOException {
        this.folderPath = folderPath;
        this.watchService = FileSystems.getDefault().newWatchService();
        folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
    }


    public void startMonitoring() {
        try {
            while (true) {
                WatchKey key = watchService.poll(5, TimeUnit.SECONDS);
                boolean changesDetected = false; // Flag to track changes

                if (key != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();
                        Path changedFile = (Path) event.context();
                        System.out.println(changedFile + " - " + kind.name());
                        changesDetected = true;
                    }
                    key.reset();
                }

                //if (!changesDetected) {
                //System.out.println("No change.");
                //}
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void close() throws IOException {
        watchService.close();
    }
}
