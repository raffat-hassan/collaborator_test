/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RAFFAT
 */
public class EmployeeDataProcessor {
     public List<Employee> readEmployeeData(String inputFilePath) 
    {
        List<Employee> employees = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(inputFilePath))) 
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                String name = parts[0];
                String hoursW=parts[1];
                Integer hoursWorked=Integer.valueOf(hoursW);
                String hourlyR=parts[2];
                Double hourlyRate=Double.valueOf(hourlyR);
                
                employees.add(new Employee(name, hoursWorked,hourlyRate));
            }
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("Error: Input file not found.");
        }
        return employees;
    }
     
     public void writeProcessedData(String outputFilePath, List<Employee> employees) 
    {
        try (PrintWriter writer = new PrintWriter(new File(outputFilePath))) 
        {
            for (Employee employee : employees) 
            {
               writer.printf(employee.toString()) ;
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Unable to write to output file.");
        }
}
}
