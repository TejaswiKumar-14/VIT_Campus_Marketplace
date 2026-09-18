package service;

import java.io.FileWriter;
import java.io.IOException;

public class ActivityLogger {

    private String fileName = "marketplace_log.txt";

    // Write activity to file
    public void logActivity(String activity) {

        try {

            FileWriter writer =
                    new FileWriter(fileName, true);

            writer.write(activity + "\n");

            writer.close();

            System.out.println(
                    "Activity logged successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while writing log file."
            );
        }
    }
}