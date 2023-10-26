package handlers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommitHandler {
    private long lastSnapshotTime;

    public CommitHandler() {
        lastSnapshotTime = System.currentTimeMillis();
    }

    public void handleCommit() {
        lastSnapshotTime = System.currentTimeMillis();
        System.out.println("Created snapshot at: " + getCurrentTime());
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(lastSnapshotTime);
        return sdf.format(resultDate);
    }
}
