package Architecture;

import Human.Patient;

import java.util.ArrayList;

public class Ward {
    private int WardNum;
    private int Capacity;
    private int AvailableBeds;
    private ArrayList<Patient> patients;

    public Ward(int ward,int capacity,int availableBeds){
        this.WardNum= ward;
        this.Capacity=capacity;
        this.AvailableBeds=availableBeds;
    }

    public int getWardNum() {
        return WardNum;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getAvailableBeds() {
        return AvailableBeds;
    }

    public boolean addPatient(Patient patient){
        if(patients.size() < Capacity){
            patients.add(patient);
            return true;
        }
        return false;
    }

    public boolean dischargePatient(Patient patient){
        for(int i=0; i<patients.size(); i++){
            if(patients.get(i)==patient){
                patients.remove(patients.get(i));
                return true;
            }
        }
        return false;
    }
}
