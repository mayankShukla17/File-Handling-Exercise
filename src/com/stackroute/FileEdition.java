package com.stackroute;
/*
Problem1
        ## Problem Statement: Read and add content to a file
        **Given a filename and content read the file and add the content in the file using
        fileInputStream and try with resources**
        **This exercise contains a class named FileEdition with the following method:**
        +fileEditor(String, String) : String
        - Should take two String values as input and return a string as result
        - Should validate the input by checking whether it is null,empty or blank space
        - Should append the second string, content in the file with file name, first string
        - Should also handle exceptions thrown by logic using try with resources and
        catch
        ## Example
        Sample Input:
        text.txt, Abraham Lincoln
        Expected Output:
        Hi my name is Abraham Lincoln
        --------------------------------------------------------
        Sample Input:
        test , Bill Clinton
        Expected Output:
        File 'test' not Found
*/

import java.io.*;
import java.util.Scanner;

public class FileEdition {
    //fileEditor() for taking input of file and String
    public static String fileEditor(String fileName, String string) {
        File file = new File(fileName);
        if (file.exists()) {
            if (string.length() == 0 || string.equals(null) || string.contains("   ")) {
                return "Please don't enter null or blank spaces or null as a content";
            } else {
                String result = "";
                try (FileInputStream fileInputStream = new FileInputStream(file);
                     BufferedInputStream bufferedInput = new BufferedInputStream(fileInputStream)
                ) {
                    int data = bufferedInput.read();
                    while (data != -1) {
                        result += (char) data;
                        data = bufferedInput.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result + " " + string;
            }
        } else {
            return "File \'" + fileName + "\' not Found";
        }
    }

    //Main Method Driver Code
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name.");
        String fileName = scanner.next();
        System.out.println("Enter the string to be added without spaces.");
        String name = scanner.next();
        String string = fileEditor(fileName, name);
        System.out.println(string);
    }
}

