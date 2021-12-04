/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Taha Al Balushi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Exercise46 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File inFile = new File("exercise46_input.txt");
        Scanner scanner = new Scanner(inFile);
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            String word  = scanner.next();
            if(words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            }
            else {
                words.put(word, 1);
            }
        }

        Set<Entry<String, Integer>> setWords = words.entrySet();
        List<Entry<String, Integer>> listWords = new ArrayList<Entry<String, Integer>>(setWords);
        Collections.sort(listWords, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> word1, Map.Entry<String, Integer> word2) {
                return word2.getValue().compareTo(word1.getValue());
            }
        });

        for (Entry<String, Integer> entry : listWords) {
            int count = entry.getValue();
            System.out.printf("%s: ", String.format("%0$-12s", entry.getKey()), count);
            printStar(count);
            System.out.println("");
        }
    }

    public static void printStar(int n) {
        for(int i =0; i < n; i++)
            System.out.print("*");
    }
}