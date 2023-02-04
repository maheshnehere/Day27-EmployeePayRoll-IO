package com.bridgelabs.day17_employee_payroll;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class CreatingWatchService {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("C:\\Users\\Sourav Prasanna\\IdeaProjects");
        path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        WatchKey key;
        while ((key = watcher.take()) != null) {
            for(WatchEvent<?> event: key.pollEvents()) {
                FileWriter eventsFile = new FileWriter("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day27-EmployeePayrollFileIO\\Events.txt");
                eventsFile.write("Event type "+event.kind()+"\nFile affected"+event.context()+"\n");
            }
        }
        key.reset();
    }
}
