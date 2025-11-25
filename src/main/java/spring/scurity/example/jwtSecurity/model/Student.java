package spring.scurity.example.jwtSecurity.model;

public class Student
{
    private String firstName;
    private String lastName;
    private int age;
    private int marks;
    public Student(String firstName, String lastName, int age, int marks)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.marks = marks;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getMarks()
    {
        return marks;
    }
    public void setMarks(int marks)
    {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
