package com.bridgelabs.day17_employee_payroll;

public class Main extends EmployeePayRollIO{
    public static void main(String[] args) {
        Main employeeIO = new Main();
        System.out.println("Enter the number of employee payroll details you would like to add");
        int value = employeeIO.scanner.nextInt();
        for(int i = 0; i < value; i++) {
            employeeIO.read();
        }
        employeeIO.write();
    }
}
