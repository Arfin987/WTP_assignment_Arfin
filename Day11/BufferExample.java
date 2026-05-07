package day_11_Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferExample {
    public static void main(String[] args) {
        try {
           
            BufferedWriter writer = new BufferedWriter(new FileWriter("new_file.txt"));
            writer.write("Hello, this file is written using BufferedWriter.");
            writer.newLine(); 
            writer.write("BufferedWriter writing text.");
            writer.close();
            System.out.println("File written successfully!");

           
            BufferedReader reader = new BufferedReader(new FileReader("new_file.txt"));
            String line;
            System.out.println("Reading file contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
