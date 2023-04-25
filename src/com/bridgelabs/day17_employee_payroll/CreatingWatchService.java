package com.bridgelabs.day17_employee_payroll;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class CreatingWatchService {
    static int countOfEvents;

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("C:\\Users\\Sourav Prasanna\\IdeaProjects");
        try (FileWriter eventsFile = new FileWriter("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day27-EmployeePayrollFileIO\\src\\com\\bridgelabs\\day17_employee_payroll\\Events.txt")) {
            path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key;
            while ((key = watcher.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    eventsFile.write("\nEvent number: " + (countOfEvents + 1) + " Event type: " + event.kind() + " File affected: " + event.context());
                }
                eventsFile.close();
            }
        }
    }
}