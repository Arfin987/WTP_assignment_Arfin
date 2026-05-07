package day_12_Assignment;

import java.io.*;

//Serializable Employee class
class Employee implements Serializable {
 int id;
 String name;
 double salary;

 Employee(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }
}

public class EmployeeS {
 public static void main(String[] args) {
     try {
   
         Employee emp1 = new Employee(101, "Ravi", 50000);
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
         oos.writeObject(emp1);
         oos.close();
         System.out.println("Employee object serialized!");

         
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"));
         Employee emp2 = (Employee) ois.readObject();
         ois.close();

         System.out.println("\n--- Employee Details ---");
         System.out.println("ID: " + emp2.id);
         System.out.println("Name: " + emp2.name);
         System.out.println("Salary: " + emp2.salary);

     } catch (IOException | ClassNotFoundException e) {
         System.out.println("Error: " + e);
     }
 }
}

