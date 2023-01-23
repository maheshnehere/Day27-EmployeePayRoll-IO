package com.bridgelabs.day17_employee_payroll;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRollIO {
    int id;
    String name;
    double salary;
    Scanner scanner = new Scanner(System.in);
    Employee employee;
    ArrayList<Employee> employees = new ArrayList<>();
    public void read() {
        System.out.println("Enter the employee id");
        id = scanner.nextInt();
        System.out.println("Enter the name of the employee");
        name = scanner.next();
        System.out.println("Enter the salary of the employee");
        salary = scanner.nextDouble();
        employee = new Employee(id, name, salary);
        employees.add(employee);
    }
    public void write() {
        for(Employee details : employees) {
            System.out.println(details);
        }
    }
}
