<<<<<<< HEAD
# File Handling Exercise

1. Problem1
Problem Statement: Read and add content to a file
**Given a filename and content read the file and add the content in the file using
fileInputStream and try with resources**
**This exercise contains a class named FileEdition with the following method:**

+fileEditor(String, String) : String
- Should take two String values as input and return a string as result
- Should validate the input by checking whether it is null,empty or blank space
- Should append the second string, content in the file with file name, first string
- Should also handle exceptions thrown by logic using try with resources and
catch

Example
Sample Input:
text.txt, Abraham Lincoln
Expected Output:
Hi my name is Abraham Lincoln

Sample Input:
test , Bill Clinton
Expected Output:
File 'test' not Found

2. Problem2
Problem Statement: Read the content from the given file(input.txt) and write the
result to another file(output.txt) without redundant lines
**Given a file by name input.txt, read content using FileInputStream and write result to
file by name output.txt by using FileOutputStream**
**This exercise contains a class named RemoveDuplicateLines with the following
method:**

+removeDuplicateLines(void) : void
- Should read content line by line from input.txt
- Should write result to output.txt

Example
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

3. Problem 3
Problem Statement: Transfer data from one file to another
**Given two file names read the first file and add the content in the second file using
bufferedStream and handle exception using throws**
**This exercise contains a class named FileMigration with the following method:**

+fileContentDuplicator(String, String) : String
- Should take two String values as input and return a string as result
- Should validate the input String by checking whether it is null or empty
- Should return an Error String when the file is empty or blank space
- Should read data from file of name first String using bufferedInputStream and 
write in file of name second String using bufferedOutputStream

Example
Sample Input:
text.txt, testBackup.txt
Expected Output:
Hi my name is

Sample Input:
test , testBackup.txt
Expected Output:
Throw IOException

Sample Input:
text.txt , null
Expected Output:
Given fileName to read or write is empty, null or blank space