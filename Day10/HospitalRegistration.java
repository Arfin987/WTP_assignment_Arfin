package day_10_Assignment;

import java.util.TreeSet;
import java.util.Scanner;

public class HospitalRegistration {
    public static void main(String[] args) {
        TreeSet<Integer> registeredPatients = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Hospital Patient Registration System ---");
        
        while (true) {
            System.out.print("\nEnter Patient ID to register (or '0' to view list & exit): ");
            int patientId = scanner.nextInt();

            if (patientId == 0) {
                break;
            }

            if (registeredPatients.contains(patientId)) {
                System.out.println("Error: ID " + patientId + " is already registered.");
            } else {
                registeredPatients.add(patientId);
                System.out.println("Success: Patient " + patientId + " added to the system.");
            }
        }

        System.out.println("\n--- Final Unique Registered Patient List ---");
        if (registeredPatients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            System.out.println(registeredPatients);
        }
        
        scanner.close();
    }
}
