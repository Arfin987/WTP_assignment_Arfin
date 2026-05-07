package day_12_Assignment;

import java.io.*;
import java.util.Scanner;

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Food Delivery Menu ---");
            System.out.println("1. Add Restaurant Menu");
            System.out.println("2. Add Customer Order");
            System.out.println("3. Add Delivery Log");
            System.out.println("4. View Delivery Records");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant Name: ");
                    String restaurant = sc.nextLine();
                    System.out.print("Enter Menu Items: ");
                    String menu = sc.nextLine();
                    saveToFile("delivery.txt", "Restaurant: " + restaurant + ", Menu: " + menu);
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Enter Order Details: ");
                    String order = sc.nextLine();
                    saveToFile("delivery.txt", "Customer: " + customer + ", Order: " + order);
                    break;

                case 3:
                    System.out.print("Enter Delivery Person Name: ");
                    String deliveryPerson = sc.nextLine();
                    System.out.print("Enter Delivery Status/Time: ");
                    String log = sc.nextLine();
                    saveToFile("delivery.txt", "Delivery By: " + deliveryPerson + ", Log: " + log);
                    break;

                case 4:
                    System.out.println("\n--- Delivery Records ---");
                    readFile("delivery.txt");
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
