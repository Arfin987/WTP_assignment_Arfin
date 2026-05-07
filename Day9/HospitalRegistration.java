package day_9_Assignment;
import java.util.*;


class Patients {
    String id;
    String name;

    Patients(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patients)) return false;
        Patients patient = (Patients) o;
        return this.id== patient.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name;
    }
}

public class HospitalRegistration {
    public static void main(String[] args) {
        HashSet<Patients> registeredPatients = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Patient\n2. View All Registered Patients\n3. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Unique ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                Patients newPatient = new Patients(id, name);

                if (registeredPatients.contains(newPatient)) {
                    System.out.println("Error: ID " + id + " is already registered.");
                } else {
                    registeredPatients.add(newPatient);
                    System.out.println("Patient added to the system.");
                }
            } 
            else if (choice == 2) {
                System.out.println("\n--- Unique Registered Patients ---");
                if (registeredPatients.isEmpty()) {
                    System.out.println("No patients registered.");
                } else {
                    for (Patients p : registeredPatients) {
                        System.out.println(p);
                    }
                }
            } 
            else if (choice == 3) {
            	System.out.println(" Exiting the System...");
                break;
            }
        }
        sc.close();
    }
}
