/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Taha Al Balushi
 */
import javax.swing.text.html.StyleSheet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Exercise 43 - Website Generator
 */
public class Exercise43 {
    /**
     *
     * @param directoryPath
     * @return
     * @throws IOException
     */
    public static File createDirectory(String directoryPath) throws IOException {
        File dir = new File(directoryPath);
        if (dir.exists()) {
            System.out.println(dir.getAbsolutePath());
            return dir;
        }
        if (dir.mkdirs()) {
            System.out.println(dir.getAbsolutePath());
            return dir;
        }
        throw new IOException("Failed to create directory '" + dir.getAbsolutePath() + "' for an unknown reason.");
    }

    /**
     *
     * @param directoryPath
     * @return
     * @throws IOException
     */
    public static void createIndexFile(String directoryPath,String author) throws IOException {
        File f = new File(directoryPath+"/index.htm");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("<html>");
        bw.write("<title>"+author+"</title>");
        bw.write("<meta>"+author+"</meta>" );
        bw.write("<body>");
        bw.write("</body></html>");
        bw.close();
    }

    public static void main(String ar[]) throws IOException {
        String siteName = null;
        String author = null;
        String folderCSS = null;
        String folderJavaScript = null;
        String homePage = "index.html";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Site name:");
        String input=sc.nextLine();
        siteName = input;

        System.out.print("Author of the site:");
        author =sc.nextLine();

        System.out.print("Do you want a folder for JavaScript?");
        input =sc.nextLine();
        if(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")){
            folderJavaScript = "/website/"+siteName+"/js/";
            createDirectory(folderJavaScript);
        }else {
            folderJavaScript = "";
        }

        System.out.print("Do you want a folder for CSS?");
        input =sc.nextLine();
        if(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")){
            folderCSS = "/website/"+siteName+"/css/";
            createDirectory(folderCSS);
        }else {
            folderCSS = "";
        }

        if (!siteName.isEmpty())
            System.out.println("Site name: "+ siteName);
        if (!author.isEmpty())
            System.out.println("Author: "+ author);
        System.out.println("Do you want a folder for JavaScript?"+ (folderJavaScript.isEmpty()?"N":"Y"));
        System.out.println("Do you want a folder for CSS?"+ (folderCSS.isEmpty()?"N":"Y"));

        if (!siteName.isEmpty()) {
            System.out.println("Created ./website/" + siteName);
            createIndexFile("/website/"+siteName,author);
            System.out.println("Created ./website/" + siteName+"/index.html");
        }
        if (!folderJavaScript.isEmpty())
            System.out.println("Created ."+ folderJavaScript);
        if (!folderCSS.isEmpty())
            System.out.println("Created ."+ folderCSS);

    }
}