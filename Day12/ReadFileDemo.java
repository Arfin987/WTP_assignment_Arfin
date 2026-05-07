package day_12_Assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDemo {
    public static void main(String[] args) {
        try {
            // Use BufferedReader for line-by-line reading
            BufferedReader reader = new BufferedReader(new FileReader("Arfin.txt"));
            String line;

            System.out.println("Reading file content line by line:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
