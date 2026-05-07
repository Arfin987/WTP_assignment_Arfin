package day_10_Assignment;

import java.util.HashMap;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        HashMap<Integer, String> patients = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Hospital Patient Records ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Retrieve Details");
            System.out.println("4. Remove Patient");
            System.out.println("5. List All Patients");
            System.out.println("6. Check Existence");
            System.out.println("7. Count Total Patients");
            System.out.println("8. Clear System");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            
            if (choice == 9) { 
            	System.out.println("Exiting ....");
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
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    if (patients.containsKey(updateId)) {
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();
                        patients.put(updateId, newName);
                    } else {
                        System.out.println("ID not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    System.out.println("Result: " + patients.getOrDefault(searchId, "Not Found"));
                    break;

                case 4:
                    System.out.print("Enter ID to remove: ");
                    int removeId = sc.nextInt();
                    patients.remove(removeId);
                    break;

                case 5:
                    System.out.println("Patient List: " + patients);
                    break;

                case 6:
                    System.out.print("Enter ID to check: ");
                    int checkId = sc.nextInt();
                    System.out.println("Exists: " + patients.containsKey(checkId));
                    break;

                case 7:
                    System.out.println("Total Patients: " + patients.size());
                    break;

                case 8:
                    patients.clear();
                    System.out.println("System cleared.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
