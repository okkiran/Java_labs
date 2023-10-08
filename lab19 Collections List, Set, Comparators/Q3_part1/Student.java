package part1;


public class Student {

    private int id;
    private String name;
    private String surname;

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "\nID: " + id + ", Name=" + name + ", Surname=" + surname + "\n";
    }
}
