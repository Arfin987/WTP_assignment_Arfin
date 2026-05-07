package day_12_Assignment;

import java.io.*;
import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Menu ---");
            System.out.println("1. Register New Patient");
            System.out.println("2. Add Medical Report");
            System.out.println("3. View Patient Records");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    String age = sc.nextLine();
                    saveToFile("patients.txt", "Patient: " + name + ", Age: " + age);
                    break;

                case 2:
                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = sc.nextLine();
                    System.out.print("Enter Report: ");
                    String report = sc.nextLine();
                    saveToFile("patients.txt", "Patient: " + patientName + ", Diagnosis: " + diagnosis + ", Report: " + report);
                    break;

                case 3:
                    System.out.println("\n--- Medical Reports ---");
                    readFile("patients.txt");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }

    public static void saveToFile(String filename, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(data);
            bw.newLine();
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e);
        }
    }
    public static void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }
}

