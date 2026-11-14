package Human;

public class Doctor extends Person {
    private String Expertise;
    private int PatientCapacity;

    public Doctor(String name, int id, int age, String expertise, int patientCapacity) {
        super(name, id, age);
        this.Expertise = expertise;
        this.PatientCapacity = patientCapacity;
    }

}
