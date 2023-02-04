package com.bridgelabs.day17_employee_payroll;

import java.io.*;
import java.util.List;
import java.util.Scanner;
public class EmployeePayRollService {
    EmployeePayRollIO employeePayRollIO = new EmployeePayRollIO();
    int count = 0;
    public void writeEmployeePayroll(List<Employee> employees) throws IOException {
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day27-EmployeePayrollFileIO\\src\\com\\bridgelabs\\day17_employee_payroll\\EmployeeParollFile.txt")) {
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
        File file = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day27-EmployeePayrollFileIO\\src\\com\\bridgelabs\\day17_employee_payroll\\EmployeeParollFile.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
