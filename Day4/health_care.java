package day_4_Assignment;



import java.util.*;


class Patient {
    private int id;
    private String name;
    private int age;
    private String illness;

    public Patient(int id, String name, int age, String illness) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.illness = illness;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getIllness() { return illness; }
}


interface PatientService {
    void registerPatient(Patient patient);
    void showPatientDetails(int id);
}

class PatientServiceImpl implements PatientService {
    private Map<Integer, Patient> patientMap = new HashMap<>();


    public void registerPatient(Patient patient) {
        patientMap.put(patient.getId(), patient);
        System.out.println("Patient registered: " + patient.getName());
    }

    public void showPatientDetails(int id) {
        Patient patient = patientMap.get(id);
        if (patient != null) {
            System.out.println("Patient ID: " + patient.getId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Illness: " + patient.getIllness());
        } else {
            System.out.println("Patient not found.");
        }
    }
}


abstract class Doctor {
    protected String name;
    protected String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public abstract void diagnose(Patient patient);
}


class GeneralPhysician extends Doctor {
    public GeneralPhysician(String name) {
        super(name, "General Physician");
    }

   
    public void diagnose(Patient patient) {
        System.out.println(name + " (" + specialization + ") is diagnosing " + patient.getName());
        System.out.println("Diagnosis: General checkup for " + patient.getIllness());
    }
}

class Cardiologist extends Doctor {
    public Cardiologist(String name) {
        super(name, "Cardiologist");
    }

    
    public void diagnose(Patient patient) {
        System.out.println(name + " (" + specialization + ") is diagnosing " + patient.getName());
        if (patient.getIllness().toLowerCase().contains("heart")) {
            System.out.println("Diagnosis: Specialized heart treatment for " + patient.getIllness());
        } else {
            System.out.println("Diagnosis: Referred to General Physician for " + patient.getIllness());
        }
    }
}


public class health_care {
    public static void main(String[] args) {
        PatientService service = new PatientServiceImpl();

        Patient p1 = new Patient(1, "Alice", 30, "Flu");
        Patient p2 = new Patient(2, "Bob", 45, "Heart Disease");

        service.registerPatient(p1);
        service.registerPatient(p2);

        service.showPatientDetails(1);
        service.showPatientDetails(2);

        Doctor gp = new GeneralPhysician("Dr. Smith");
        Doctor cardio = new Cardiologist("Dr. Johnson");

        gp.diagnose(p1);
        gp.diagnose(p2);

        cardio.diagnose(p1);
        cardio.diagnose(p2);
    }
}

