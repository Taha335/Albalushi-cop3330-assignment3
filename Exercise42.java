/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Taha Al Balushi
 */

import com.opencsv.CSVReader;

import javax.swing.text.html.StyleSheet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Exercise 42 - Parsing a Data File
 */

class Employee {
    private String lastName;
    private String firstName;
    private Double salary;

    public Employee() {
        this.lastName = "";
        this.firstName = "";
        this.salary = 0.0;
    }

    public Employee(String lastName, String firstName, Double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                '}';
    }

    private String fillspace(String value, int max) {
        if (value.length() < max) {
            int minLength = max - value.length();
            for (int i = 0; i <= minLength; i++) {
                value = value + " ";
            }
        }
        return value;
    }

    public void printOutTable(List<Employee> list) {
        System.out.println("Last                 First               Salary");
        System.out.println("----------------------------------------------------------");
        for (Employee emp : list
        ) {

            System.out.print(fillspace(emp.getLastName(), 20));
            System.out.print(fillspace(emp.getFirstName(), 20));
            System.out.println(fillspace(String.valueOf(emp.getSalary()), 20));
        }
    }

    Comparator<Employee> compareBySalary = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getSalary().compareTo(o2.getSalary());
        }
    };


}

public class Exercise42 {

    /**
     * @param fileName
     * @return
     * @throws IOException
     */
    private static ArrayList<Employee> readEmployeeFile(String fileName) throws IOException {
        ArrayList<Employee> listReadEmp = new ArrayList<Employee>();

        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        String row = null;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
            Employee emp = new Employee();
            emp.setLastName(data[0]);
            emp.setFirstName(data[1]);
            emp.setSalary(Double.valueOf(data[2]));
            listReadEmp.add(emp);
        }
        csvReader.close();
        return listReadEmp;
    }

    private static ArrayList<Employee> readEmployeeFileByOpenCsv(String fileName) throws IOException {
        ArrayList<Employee> listReadEmp = new ArrayList<Employee>();

        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                Employee emp = new Employee();
                emp.setLastName(values[0]);
                emp.setFirstName(values[1]);
                emp.setSalary(Double.valueOf(values[2]));
                listReadEmp.add(emp);
            }
        }
        return listReadEmp;
    }

    public static void main(String ar[]) throws IOException {
        String fileName = "exercise42_input.txt";


        Employee emp = new Employee();

        ArrayList<Employee> employees = readEmployeeFile(fileName);
        ArrayList<Employee> listEmpOpenByCSV = readEmployeeFileByOpenCsv(fileName);

        //Compare to sort
        Comparator<Employee> compareById =
                (Employee o1, Employee o2) -> o1.getSalary().compareTo( o2.getSalary() );
        Collections.sort(employees, compareById.reversed());
        emp.printOutTable(employees);

        System.out.println("Rework your program to use a CSV parsing library and compare the results");
        Collections.sort(listEmpOpenByCSV, compareById.reversed());
        emp.printOutTable(listEmpOpenByCSV);

    }
}