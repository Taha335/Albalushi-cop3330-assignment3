/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Taha Al Balushi
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Exercise45 {
    public static void main(String ar[]) throws IOException {
        // TODO code application logic here
        File inFile = new File("exercise45_input.txt");

        FileWriter outFile = new FileWriter("exercise45_output.txt");
        //outFile.write("Files in Java might be tricky, but it is fun enough!");

        Scanner scanner = new Scanner(inFile);
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        while (scanner.hasNextLine()) {
            String line  = scanner.nextLine();
            outFile.write(line.replace("utilize", "use"));
            outFile.write("\n");
        }
        outFile.close();
    }
}