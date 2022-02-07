import java.util.Stack;

public class Student implements Comparable<Student>  {
    private String firstName;
    private String lastName;
    private int id;
    private int year;

    public Student(String firstName, String lastName, int id, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        return this.getId() - o.getId();
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof  Student) && compareTo((Student) o) == 0;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + id + " " + year ;
    }

}
