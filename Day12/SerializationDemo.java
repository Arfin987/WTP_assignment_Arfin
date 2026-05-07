package day_12_Assignment;

import java.io.*;


class Student implements Serializable {
 int id;
 String name;

 Student(int id, String name) {
     this.id = id;
     this.name = name;
 }
}

public class SerializationDemo {
 public static void main(String[] args) {
     try {       
         Student s1 = new Student(100, "Arfin");

  
         FileOutputStream fo = new FileOutputStream("file.txt");
         ObjectOutputStream oo = new ObjectOutputStream(fo);

         oo.writeObject(s1); 
         oo.close();
         fo.close();

         System.out.println("Object serialized successfully!");
     } catch (IOException e) {
         System.out.println("Error during serialization: " + e);
     }
 }
}

