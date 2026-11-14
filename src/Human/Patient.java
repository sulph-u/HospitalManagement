package Human;

public class Patient extends Person{
    private String Diseases;
    private String Status;


    public Patient(String name, int id, int age, String disease, String status) {
        super(name, id, age);
        this.Diseases = disease;
        this.Status = status;
    }
}
