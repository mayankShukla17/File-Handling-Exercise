package com.stackroute;
/*
Problem 3
        ## Problem Statement: Transfer data from one file to another
        **Given two file names read the first file and add the content in the second file using
        bufferedStream and handle exception using throws**
        **This exercise contains a class named FileMigration with the following method:**
        +fileContentDuplicator(String, String) : String
        - Should take two String values as input and return a string as result
        - Should validate the input String by checking whether it is null or empty
        - Should return an Error String when the file is empty or blank space
        - Should read data from file of name first String using bufferedInputStream and
        write in file of name second String using bufferedOutputStream
        ## Example
        Sample Input:
        text.txt, testBackup.txt
        Expected Output:
        Hi my name is
        --------------------------------------------------------
        Sample Input:
        test , testBackup.txt
        Expected Output:
        Throw IOException
        --------------------------------------------------------
        Sample Input:
        test.txt , null
        Expected Output:
        Given fileName to read or write is empty, null or blank space
*/

import java.io.*;
import java.util.Scanner;

public class FileMigration {
    //fileContentDuplicator() for duplicating the files
    public static String fileContentDuplicator(String fileOne, String fileTwo) throws IOException {
        File file1 = new File(fileOne);
        File file2 = new File(fileTwo);
        if (file1.exists() && file2.exists()) {
            if (file1.length() == 0 || file1.equals(null) && file2.length() == 0 || file2.equals(null)) {
                return "Given fileName to read or write is empty, null or blank space";
            } else {
                String result = "";
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    int data;
                    do {
                        data = bufferedInputStream.read();
                        if (data != -1) {
                            bufferedOutputStream.write(data);
                            result += (char) data;
                        }
                    } while (data != -1);
                    bufferedOutputStream.flush();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }
        } else {
            throw new IOException("File Not Found");
        }
    }

    //Main Method Driver Code
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name.");
        String firstFile = scanner.next();
        System.out.println("Enter the file in which you want to copy.");
        String secondFile = scanner.next();
        String string = fileContentDuplicator(firstFile, secondFile);
        System.out.println(string);
        System.out.println("Successfully Copied");
    }
}
