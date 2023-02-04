package com.bridgelabs.day17_employee_payroll;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main extends EmployeePayRollIO{
    Scanner scanner1 = new Scanner(System.in);
    String fileName;
    FileOperations fileOperations = new FileOperations("C:\\Users\\Sourav Prasanna\\IdeaProjects");
    public void menu() throws IOException, InterruptedException {
        System.out.println("Menu: 1. Enter the path 2. Check file exist in given path 3. Delete a file/directory 4. Create a directory 5. Create Empty file " +
                "6. List all files in given path 7. Exit");
        System.out.println("Note: The default path is C:\\Users\\Sourav Prasanna\\IdeaProjects\nif you wish to add a new path enter 1");
        int option = scanner1.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the file path to be added");
                String path = scanner1.next();
                fileOperations = new FileOperations("C:\\Users\\Sourav Prasanna\\IdeaProjects"+"\\"+path);
                System.out.println("File path has been successfully added");
                menu();
                break;
            case 2:
                System.out.println("Enter the name of the directory/file to check whether it exist or not");
                fileName = scanner1.next();
                fileOperations.isFileExists(fileName);
                menu();
                break;
            case 3:
                System.out.println("Enter the name of the file to delete the file");
                fileName = scanner1.next();
                fileOperations.deleteFile(fileName);
                menu();
                break;
            case 4:
                fileOperations.createDirectory();
                menu();
                break;
            case 5:
                fileOperations.createEmptyFile();
                menu();
                break;
            case 6:
                fileOperations.listOfFiles();
                menu();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }

    }
    public static void main(String[] args) throws IOException, InterruptedException {
//        Main employeeIO = new Main();
//        System.out.println("Enter the number of employee payroll details you would like to add");
//        int value = employeeIO.scanner.nextInt();
//        for(int i = 0; i < value; i++) {
//            employeeIO.read(); //this method will do the read operation
//        }
//        employeeIO.write(); //this method will do the write operation
        Main main = new Main();
        main.menu();
    }
}
