package com.stackroute;
/*
Problem2
        ## Problem Statement: Read the content from the given file(input.txt) and write the
        result to another file(output.txt) without redundant lines ##
        **Given a file by name input.txt, read content using FileInputStream and write result to
        file by name output.txt by using FileOutputStream**
        **This exercise contains a class named RemoveDuplicateLines with the following
        method:**
        +removeDuplicateLines(void) : void
        -Should read content line by line from input.txt
        -Should write result to output.txt
        ## Example
        Sample Input:
        input.txt
        JVM
        JRE
        JDK
        JRE
        JVM
        Expected Output:
        output.txt
        JVM
        JRE
        JDK
*/

import java.io.*;
import java.util.LinkedHashSet;

public class RemoveDuplicateLines {
    //removeDuplicateLines() for Removing the duplicates
    public static void removeDuplicateLines() {
        try {
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String stringLine;
            LinkedHashSet<String> set = new LinkedHashSet<String>();

            //Read File Line By Line
            while ((stringLine = bufferedReader.readLine()) != null) {
                // Print the content on the console
                set.add(stringLine);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File("output.txt"));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            //Write the data one by one in file
            for (String s : set) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            //Close the input/output stream
            dataInputStream.close();
            bufferedWriter.close();
            fileOutputStream.close();
            System.out.println("Data Successfully Copied and Duplicates Removed");
        } catch (Exception e) {     //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Main Method Driver Code
    public static void main(String[] args) {
        removeDuplicateLines();
    }
}
