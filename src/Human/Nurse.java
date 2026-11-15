package Human;

import java.util.ArrayList;

public class Nurse extends Person implements Available{
    private int PatientCapacity;
    private ArrayList<Patient> PatientTally = new ArrayList<>();

    public Nurse(String name, int id, int age, int patientCapacity) {
        super(name, id, age);
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
        System.out.println("Cannot add patient to Nurse's List");
    }

    public boolean removePatient(Patient patient) {
        return PatientTally.remove(patient);
    }
}
