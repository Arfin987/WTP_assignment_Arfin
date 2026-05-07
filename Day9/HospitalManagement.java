package day_9_Assignment;
import java.util.LinkedList;
import java.util.Scanner;

class patient {
    String name;
    String condition;

    patient(String name, String condition) {
        this.name = name;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Patient: " + name + " (Condition: " + condition + ")";
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        LinkedList<patient> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--- Hospital Management ---");
            System.out.println("1. Add Regular Patient (End)");
            System.out.println("2. Add Emergency Patient (Front)");
            System.out.println("3. Remove/Treat Next Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Condition: ");
                String cond = sc.nextLine();
                queue.addLast(new patient(name, cond));
            } 
            else if (choice == 2) {
                System.out.print("EMERGENCY Name: ");
                String name = sc.nextLine();
                System.out.print("Condition: ");
                String cond = sc.nextLine();
                queue.addFirst(new patient(name, cond));
            } 
            else if (choice == 3) {
                if (!queue.isEmpty()) {
                    System.out.println("Treating: " + queue.removeFirst());
                } else {
                    System.out.println("Queue is empty.");
                }
            } 
            else if (choice == 4) {
                if (queue.isEmpty()) {
                    System.out.println("No patients in queue.");
                } else {
                    for (patient p : queue) System.out.println(p);
                }
            } 
          
            else if (choice == 5) {
            	System.out.println("Exiting System...");
                break;
            }
        }
        sc.close();
    }
}

