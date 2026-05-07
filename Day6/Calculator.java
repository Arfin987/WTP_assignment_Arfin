package day_6_Assignment;

class Arithmetic { 
    public double add(double a, double b) { 
        return a + b; 
    } 
 
    public double subtract(double a, double b) { 
        return a - b; 
    } 
} 
 
public class Calculator { 
    public static void main(String[] args) { 
        Arithmetic operation = new Arithmetic(); 
 
        double sum = operation.add(15.5, 4.5); 
        double diff = operation.subtract(20.0, 5.5); 
        System.out.println("Addition Result: " + sum); 
        System.out.println("Subtraction Result: " + diff); 
    } 
} 
