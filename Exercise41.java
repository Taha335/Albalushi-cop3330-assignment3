/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Taha Al Balushi
 */
import javax.swing.text.html.StyleSheet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Exercise 41 - Name Sorter
 */
public class Exercise41 {

    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    private static List readFile(String fileName) throws IOException {

        List<String> result = new ArrayList<>();
        BufferedReader buff = null;
        try {

            buff = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = buff.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buff != null) {
                buff.close();
            }
        }

        return result;
    }

    /**
     *
     * @param list
     * @throws IOException
     */
    private static void sortAndPrint(List list) throws IOException {

        if (!list.isEmpty()){
            System.out.println("Total of " +list.size()+ " names");
            System.out.println("---------------------------------");
            Collections.sort(list);//sorts the list alphabetically
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }


    }

    public static void main(String ar[]) throws IOException {
        String fileName = "exercise41_input.txt";
        List listName = readFile(fileName);
        sortAndPrint(listName);
    }
}