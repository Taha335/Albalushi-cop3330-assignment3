/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Taha Al Balushi
 */
import javax.swing.text.html.StyleSheet;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * Exercise 44 - Product Search
 */

class Product {

    private String name;
    private Double price;
    private Double quantity;

    public Product() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0.0;
    }

    public Product(String name, Double price, Double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }


}

public class Exercise44 {

    public static ArrayList<Product> readFileJsonProduct(String file){
        JSONParser parser = new JSONParser();
        ArrayList<Product> result = new ArrayList<Product>();
        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonProducts= (JSONObject)obj;
            JSONArray products = (JSONArray)jsonProducts.get("products");
            System.out.println("products:");
            Iterator iterator = products.iterator();
            while (iterator.hasNext()) {
                JSONObject product = (JSONObject) iterator.next();
                String pName = (String)product.get("name");
                Double price = Double.valueOf(product.get("price").toString());
                Double quantity = Double.valueOf(product.get("quantity").toString());
                Product objProduct = new Product(pName,price,quantity);
                result.add(objProduct);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Product SearchProduct(ArrayList<Product> arrayListProduct, String name){
        for(Product p : arrayListProduct){
            if(p.getName() != null && p.getName().equalsIgnoreCase(name)) {
                return  p;
            }
        }
        return null;
    }
    public static void main(String ar[]) {
        ArrayList<Product> arrayListProduct = new ArrayList<Product>();
        arrayListProduct=readFileJsonProduct("exercise44_input.json");

        Scanner sc = new Scanner(System.in);
        System.out.print("What is the product name? ");
        //String input=sc.nextLine();
        while(sc.hasNext()) {
            String s1 = sc.next();
            if(s1.equals("exit")) {
                break;
            }
            Product product = SearchProduct(arrayListProduct,s1);
            if (product == null){
                System.out.println("Sorry, that product was not found in our inventory.");
            }else {
                System.out.println("Name: "+product.getName());
                System.out.println("Price: "+product.getPrice());
                System.out.println("Quantity: "+product.getQuantity());
            }
            System.out.print("What is the product name? ");
            //input=sc.nextLine();

        }


    }
}