package com.bridgelabs.day17_employee_payroll;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class FileOperations {
    static String path;
    Scanner scanner = new Scanner(System.in);
    public FileOperations(String path) {
        this.path = path; //from the constructor getting the file path
    }
    public boolean isFileExists(String fileName) {
        File file1 = new File(path+"\\"+fileName); //to check the file in the given path adding file to the path
        if(file1.exists()) {
            System.out.println("Yes, the directory/file does exists");
            return true;
        }
        else {
            System.out.println("No, the directory/file doesn't exists in the given path");
            return false;
        }
    }
    public void deleteFile(String fileName) {
        File file2 = new File(path+"\\"+fileName); //again getting file name via parameter to be deleted
        if(isFileExists(fileName)) {
            file2.delete();
            System.out.println("File deleted successfully");
        }
        else
            System.out.println("File doesn't exists");
    }
    public void createDirectory() {
        System.out.println("Enter name of the directory to create");
        String path2 = path+"\\"+scanner.next();
        File file3 = new File(path2);
        file3.mkdir();
        System.out.println("Directory has been created successfully");
    }
    public void createEmptyFile() throws IOException {
        System.out.println("Enter the name of the file with extension to create");
        String fileName = scanner.next();
        File file4 = new File(path+"\\"+fileName);
        file4.createNewFile();
        System.out.println("File create successfully");
    }
    public void listOfFiles() {
        File file5 = new File(path);
        String[] list = file5.list(); //this method will show the list of files in the given path
        String nextLine;
        for(int i = 0; i < list.length; i++) {
            if(i%4 == 0 && i != 0) //in order to show the files in rows and columns we are using this condition
                nextLine = "\n";
            else
                nextLine = "\t";
            System.out.print("--"+list[i]+nextLine);
        }
    }
}
