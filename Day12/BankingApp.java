package day_12_Assignment;

import java.io.*;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Transaction History");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String customerDeposit = sc.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    String depositAmount = sc.nextLine();
                    saveToFile("transactions.txt", "Customer: " + customerDeposit + ", Deposit: " + depositAmount);
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String customerWithdraw = sc.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    String withdrawAmount = sc.nextLine();
                    saveToFile("transactions.txt", "Customer: " + customerWithdraw + ", Withdrawal: " + withdrawAmount);
                    break;

                case 3:
                    System.out.println("\n--- Account Details ---");
                    readFile("transactions.txt");
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
            System.out.println("Transaction saved to " + filename);
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

