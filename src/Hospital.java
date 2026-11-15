import Architecture.Building;
import Architecture.Room;
import Architecture.Ward;
import Human.Doctor;
import Human.Nurse;
import Human.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private String Name;
    private String Address;
    ArrayList<Building> buildings = new ArrayList<>();
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Nurse> nurses = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();


    public Hospital(String name, String address) {
       this.Name = name;
       this.Address = address;
    }
    public void addBuilding(int buildingNum,String buildName){
        Building B1=new Building(buildingNum,buildName);
        buildings.add(B1);

    }
    public void PrintBuilding(){
        for(int i=0;i<buildings.size();i++){
            System.out.println(buildings.get(i).getBuildName());
        }
    }

    public void addRoomToBuilding(int buildingNum,int roomNum,String roomName){
        for(int i=0;i<buildings.size();i++){
            if(buildings.get(i).getBuildingNum()==buildingNum){
                Room room=new Room(roomNum,roomName);
                buildings.get(i).addRoom(room);
            }
        }

    }
    public void addWardToRoom(int buildingNum,int roomNum,int WardNum, int capacity, int availableBeds){
        for(int i=0;i<buildings.size();i++){
            if(buildings.get(i).getBuildingNum()==buildingNum ){
                for(int j=0;j<buildings.get(i).getRooms().size();j++){
                    if(buildings.get(i).getRooms().get(j).getRoomNum()==roomNum){
                        Ward wards=new Ward(WardNum,capacity,availableBeds);
                        buildings.get(i).getRooms().get(j).Addward(wards);
                    }
                }
            }
        }
    }

    public void addDoctor(String name, int ID, int age, String specialization, int patientCapacity){
        Doctor doc = new Doctor(name, ID, age, specialization, patientCapacity);
        doctors.add(doc);
    }

    public void addNurse(String name, int ID, int age, int patientCapacity){
        Nurse nurse = new Nurse(name, ID, age, patientCapacity);
        nurses.add(nurse);
    }

    public void addPatient(String name, int ID, int age, String disease, String condition){
        Patient patient = new Patient(name, ID, age, disease, condition);
        patients.add(patient);
    }

    public void admitPatient(int patientID, int buildindNo, int roomNo, int wardNo){
        for(int i=0; i<patients.size(); i++){
            if(patients.get(i).getId() == patientID){
                patients.get(i).admit(buildindNo, roomNo, wardNo);
                System.out.println("Patient added to ward.");
            }
        }
        System.out.println("No paitent found!");
    }

    public void assignDoctor(int docID, int patientID){
        for(int i=0;i<doctors.size();i++){
            if(doctors.get(i).getId()==docID){
                for(int j=0;j<patients.size();j++){
                    if(patients.get(j).getId()==patientID){
                        patients.get(j).assignDoctor(doctors.get(i));
                        doctors.get(i).addPatient(patients.get(j));
                        return;
                    }
                    System.out.println("Patient with ID: " + patientID +"not found.");
                    return;
                }
            }
            System.out.println("Doctor with ID " +docID +" not found ");
            return;
        }
    }


    public void assignNurse(int nurseID, int patientID){
        for(int i=0; i<nurses.size(); i++){
            if(nurses.get(i).getId()==nurseID){
                for(int j=0; j<patients.size(); j++){
                    if(patients.get(j).getId()==patientID){
                        patients.get(j).assignNurse(nurses.get(i));
                        nurses.get(j).addPatient(patients.get(j));
                        System.out.println("Nurse " + nurseID + " successfully assigned to Patient : "+ patientID);
                    }
                }
            }
        }
    }

    public void removePatient(int patientID) {
        for(int i=0;  i<doctors.size(); i++){
            for(int j=0; j<doctors.get(i).getPatientTally().size(); j++){
                if(doctors.get(i).getPatientTally().get(j).getId()==patientID){
                    doctors.get(i).removePatient(doctors.get(i).getPatientTally().get(j));
                }
            }
        }
        for(int i = 0; i < nurses.size(); i++){
            for(int j = 0; j < patients.size(); j++){
                if(patients.get(j).getId() == patientID){
                    nurses.get(i).removePatient(patients.get(j));
                }
            }
        }

        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).getId() == patientID){
                patients.remove(patients.get(i));
            }
        }
        System.out.println("Patient with ID: " + patientID + " released successfully.");
    }

    static void main(String[] args) {
        Hospital h = new Hospital("Gollamari General Hospital", "Gollamari, Khulna");
        Scanner scanner = new Scanner(System.in);
        int select = 999;
        while (select != 0) {
            System.out.println("-------------------------");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Nurse");
            System.out.println("3. Add Patient");
            System.out.println("4. Add Building");
            System.out.println("5. Add Room");
            System.out.println("6. Add Ward");
            System.out.println("7. Admit Patient");
            System.out.println("8. Assign Doctor");
            System.out.println("9. Assign Nurse");
            System.out.println("10. Remove Patient");
            System.out.println("0. Exit");
            System.out.println("-------------------------");
            System.out.print("Choose an option: ");
            select = scanner.nextInt();
            scanner.nextLine();

            if (select == 1) {
                String name, specialization;
                int ID, age, capacity;
                System.out.print("Enter Doctor's name: ");
                name = scanner.nextLine();
                System.out.print("Enter Doctor's ID: ");
                ID = scanner.nextInt();
                System.out.print("Enter Doctor's age: ");
                age = scanner.nextInt();
                System.out.print("Enter Doctor's patient capacity: ");
                capacity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Doctor's specialization: ");
                specialization = scanner.nextLine();
                h.addDoctor(name, ID, age, specialization, capacity);
            } else if (select == 2) {
                String name;
                int ID, age, capacity;
                System.out.print("Enter Nurse's name: ");
                name = scanner.nextLine();
                System.out.print("Enter Nurse's ID: ");
                ID = scanner.nextInt();
                System.out.print("Enter Nurse's age: ");
                age = scanner.nextInt();
                System.out.print("Enter Nurse's patient capacity: ");
                capacity = scanner.nextInt();
                scanner.nextLine();
                h.addNurse(name, ID, age, capacity);
            } else if (select == 3) {
                String name, disease, condition;
                int ID, age;
                System.out.print("Enter Patient's name: ");
                name = scanner.nextLine();
                System.out.print("Enter Patient's ID: ");
                ID = scanner.nextInt();
                System.out.print("Enter Patient's age: ");
                age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Patient's disease: ");
                disease = scanner.nextLine();
                System.out.print("Enter Patient's condition: ");
                condition = scanner.nextLine();
                h.addPatient(name, ID, age, disease, condition);
            } else if (select == 4) {
                int buildingNo;
                String buildingName;
                System.out.print("Enter Building number: ");
                buildingNo = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Building name: ");
                buildingName = scanner.nextLine();
                h.addBuilding(buildingNo, buildingName);
            } else if (select == 5) {
                int buildingNo, roomNo;
                String roomName;
                System.out.print("Enter Building number: ");
                buildingNo = scanner.nextInt();
                System.out.print("Enter Room number: ");
                roomNo = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Room name: ");
                roomName = scanner.nextLine();
                h.addRoomToBuilding(buildingNo, roomNo, roomName);
            } else if (select == 6) {
                int buildingNo, roomNo, wardNo, capacity, noOfBeds;
                System.out.print("Enter Building number: ");
                buildingNo = scanner.nextInt();
                System.out.print("Enter Room number: ");
                roomNo = scanner.nextInt();
                System.out.print("Enter Ward number: ");
                wardNo = scanner.nextInt();
                System.out.print("Enter Ward capacity: ");
                capacity = scanner.nextInt();
                System.out.print("Enter Ward numberOfBeds: ");
                noOfBeds = scanner.nextInt();
                scanner.nextLine();
                h.addWardToRoom(buildingNo, roomNo, wardNo, capacity, noOfBeds);
            } else if (select == 7) {
                int patientID, buildingNo, roomNo, wardNo;
                System.out.print("Enter Patient's ID: ");
                patientID = scanner.nextInt();
                System.out.print("Enter Building number: ");
                buildingNo = scanner.nextInt();
                System.out.print("Enter Room number: ");
                roomNo = scanner.nextInt();
                System.out.print("Enter Ward number: ");
                wardNo = scanner.nextInt();
                scanner.nextLine();
                h.admitPatient(patientID, buildingNo, roomNo, wardNo);
            } else if (select == 8) {
                int docID, patientID;
                System.out.print("Enter Doctor's ID: ");
                docID = scanner.nextInt();
                System.out.print("Enter Patient's ID: ");
                patientID = scanner.nextInt();
                scanner.nextLine();
                h.assignDoctor(docID, patientID);
            } else if (select == 9) {
                int nurseID, patientID;
                System.out.print("Enter Nurse's ID: ");
                nurseID = scanner.nextInt();
                System.out.print("Enter Patient's ID: ");
                patientID = scanner.nextInt();
                scanner.nextLine();
                h.assignNurse(nurseID, patientID);
            } else if (select == 10) {
                for(Patient p: h.patients){
                    System.out.println(p);
                }
                int patientID;
                System.out.print("Enter Patient's ID: ");
                patientID = scanner.nextInt();
                scanner.nextLine();
                h.removePatient(patientID);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


