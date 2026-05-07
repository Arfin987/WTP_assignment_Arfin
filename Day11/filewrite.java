package day_11_Assignment;
import java.io.FileWriter;
import java.io.IOException;

public class filewrite {
    public static void main(String[] args) {
        try {
            
            FileWriter fw = new FileWriter("output.txt");

            
            fw.write("Hello, this is my first file!\n");
            fw.write("Java makes file writing easy.\n");

            
            fw.close();

            
            System.out.println("File written successfully!");
        } catch (IOException e) {
           
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}



