package Human;

import javax.print.Doc;
import java.util.ArrayList;

public class Patient extends Person{
    private String Diseases;
    private String Status;
    private ArrayList<Doctor> appointedDoctors;
    private ArrayList<Nurse> appointedNurses;
    private int BuildingNo;
    private int RoomNo;
    private int WardNo;


    public Patient(String name, int id, int age, String disease, String status) {
        super(name, id, age);
        this.Diseases = disease;
        this.Status = status;
    }

    public boolean assignDoctor(Doctor doctor){
        if(doctor.isFree()){
            appointedDoctors.add(doctor);
            System.out.println("Doctor added successfully to patients list.");
            return true;
        }
        System.out.println("Doctor can't be added to patients list.");
        return false;
    }

    public boolean removeDoctor(Doctor doctor){
        return assignDoctor(doctor);
    }

    public boolean assignNurse(Nurse nurse){
        if(nurse.isFree()){
            appointedNurses.add(nurse);
            System.out.println("Nurse added successfully to patients list.");
            return true;
        }
        System.out.println("Nurse can't be added to patients list.");
        return false;
    }

    public boolean removeNurse(Nurse nurse){
        return appointedNurses.remove(nurse);
    }

    public void admit(int BuildingNo, int RoomNo, int WardNo){
        this.BuildingNo = BuildingNo;
        this.RoomNo = RoomNo;
        this.WardNo = WardNo;
    }
}
