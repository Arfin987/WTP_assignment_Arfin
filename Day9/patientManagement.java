package day_9_Assignment;
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;
    int age;
    String illness;

    Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }

    @Override
    public String toString() {
        return "Name: " + name + "  Age: " + age + "  Illness: " + illness;
    }
}

public class patientManagement {
    public static void main(String[] args) {
        ArrayList<Patient> patientList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--- OPD Patient Management ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Illness: ");
                String illness = sc.nextLine();
                
                patientList.add(new Patient(name, age, illness));
                System.out.println("Patient registered successfully.");
            } 
            else if (choice == 2) {
                if (patientList.isEmpty()) {
                    System.out.println("No patients registered today.");
                } else {
                    for (Patient p : patientList) {
                        System.out.println(p);
                    }
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter name to search: ");
                String searchName = sc.nextLine();
                boolean found = false;
                for (Patient p : patientList) {
                    if (p.name.equalsIgnoreCase(searchName)) {
                        System.out.println("Patient Found: " + p);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No record found for: " + searchName);
                }
            } 
            else if (choice == 4) {
                System.out.println("Exiting System...");
                break;
            } 
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
