package com.bridgelabs.day17_employee_payroll;

import java.io.*;
import java.util.List;
import java.util.Scanner;
public class EmployeePayRollService {
    EmployeePayRollIO employeePayRollIO = new EmployeePayRollIO();
    int count = 0;
    File file = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day27-EmployeePayrollFileIO\\src\\com\\bridgelabs\\day17_employee_payroll\\EmployeeParollFile.txt");
    Scanner scanner = new Scanner(file);

    public EmployeePayRollService() throws FileNotFoundException {
    }

    public void writeEmployeePayroll(List<Employee> employees) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Employee values : employees) {
                fileWriter.write(values.toString()+"\n");
                count++;
            }
            fileWriter.close();
            if (employeePayRollIO.entries == count)
                System.out.println("All entries are listed in the file");

        }
    }
    public void readEmployeePayroll() throws FileNotFoundException {
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
    public void findNumberOfEntries() {
        while (scanner.hasNext()) {
            while (scanner.nextLine().toLowerCase().contains("id")) {
                count++;
            }
        }
        System.out.println("Number od entries in the file are "+count);
    }
}
