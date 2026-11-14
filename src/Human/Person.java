package Human;

public class Person {
    private String Name;
    private int Id;
    private int Age;

    public Person(String name, int id, int age) {
       this.Name = name;
        this.Id = id;
        this.Age = age;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public int getAge() {
        return Age;
    }
}

