package day_12_Assignment;

import java.io.*;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- E-Commerce Menu ---");
            System.out.println("1. Create New Order");
            System.out.println("2. Generate Invoice");
            System.out.println("3. Save Shipping Details");
            System.out.println("4. View Orders");
            System.out.println("5. View Invoices");
            System.out.println("6. View Shipping Details");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Order ID: ");
                    String orderId = sc.nextLine();
                    System.out.print("Enter Product: ");
                    String product = sc.nextLine();
                    saveToFile("orders.txt", "Order ID: " + orderId + ", Product: " + product);
                    break;

                case 2:
                    System.out.print("Enter Invoice ID: ");
                    String invoiceId = sc.nextLine();
                    System.out.print("Enter Status (Paid/Unpaid): ");
                    String status = sc.nextLine();
                    saveToFile("invoices.txt", "Invoice ID: " + invoiceId + ", Status: " + status);
                    break;

                case 3:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Shipping Address: ");
                    String address = sc.nextLine();
                    saveToFile("shipping.txt", "Customer: " + name + ", Address: " + address);
                    break;

                case 4:
                    System.out.println("\n--- Orders ---");
                    readFile("orders.txt");
                    break;

                case 5:
                    System.out.println("\n--- Invoices ---");
                    readFile("invoices.txt");
                    break;

                case 6:
                    System.out.println("\n--- Shipping Details ---");
                    readFile("shipping.txt");
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
