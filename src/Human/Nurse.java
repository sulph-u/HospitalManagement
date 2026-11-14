package Human;

public class Nurse extends Person{
    private int PatientCapacity;
    //private Patient[] PatientTally;

    public Nurse(String name, int id, int age, int patientCapacity) {
        super(name, id, age);
        this.PatientCapacity = patientCapacity;
    }
}
