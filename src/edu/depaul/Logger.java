package edu.depaul;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_PATH = "log.txt";
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        String timestamp = LocalDateTime.now().format(DATE_TIME_FORMAT);
        String logMessage = timestamp + " - " + message;

        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_PATH, true))) {
            writer.println(logMessage);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static void clearLog() {
        File logFile = new File(LOG_PATH);
        if (logFile.exists()) {
            if (logFile.delete()) {
                System.out.println("Log file deleted successfully.");
            } else {
                System.err.println("Failed to delete log file.");
            }
        } else {
            System.err.println("Log file does not exist.");
        }
    }

}
