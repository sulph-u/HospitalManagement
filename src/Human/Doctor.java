package Human;

import java.util.ArrayList;

public class Doctor extends Person implements Available{
    private String Expertise;
    private int PatientCapacity;
    private ArrayList<Patient> PatientTally = new ArrayList<>();

    public Doctor(String name, int id, int age, String expertise, int patientCapacity) {
        super(name, id, age);
        this.Expertise = expertise;
        this.PatientCapacity = patientCapacity;
    }

    public boolean isFree() {
        if(PatientTally.size() < PatientCapacity){
            return true;
        }
        return false;
    }

    public void addPatient(Patient patient) {
        if(PatientTally.size() < this.PatientCapacity){
            PatientTally.add(patient);
            System.out.println("Patient added successfully.");
            return;
        }
        System.out.println("Cannot add patient to Doctors List");
    }

    public boolean removePatient(Patient patient) {
        return PatientTally.remove(patient);
    }

    public ArrayList<Patient> getPatientTally() {
        return PatientTally;
    }
}
