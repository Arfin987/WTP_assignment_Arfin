package day_10_Assignment;

import java.util.TreeMap;
import java.util.Scanner;

public class HospitalTreeMAP {
    public static void main(String[] args) {
        TreeMap<Integer, String> patients = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Hospital Records (Sorted) ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Retrieve Details");
            System.out.println("4. Remove Patient");
            System.out.println("5. List All Patients");
            System.out.println("6. Check Existence");
            System.out.println("7. Count Total Patients");
            System.out.println("8. Clear System");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            
            int choice = sc.nextInt();
            if (choice == 9) {
                 System.out.println("Exiting... ");
            	break;}

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    patients.put(id, name);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int upId = sc.nextInt();
                    if (patients.containsKey(upId)) {
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        patients.put(upId, sc.nextLine());
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    System.out.println("Name: " + patients.get(sc.nextInt()));
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    patients.remove(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Records (Sorted): " + patients);
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    System.out.println("Exists: " + patients.containsKey(sc.nextInt()));
                    break;

                case 7:
                    System.out.println("Total: " + patients.size());
                    break;

                case 8:
                    patients.clear();
                    System.out.println("Cleared.");
                    break;

                default:
                    System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}