package CompanyRosterExercise;

public class Employee {
    /*
    Define a class Employee that holds the following information: name, salary, position, department, email and age.
    The name, salary, position and department are mandatory while the rest are optional.
     */
    private String name;
    private double salary;
    private String position;
    private String department;
    //optional
    private String email;
    private int age;


    //1.name, salary, position, department
    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;

    }

    //2.name, salary, position, department, email, age
    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    //3.name, salary, position, department, email
    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
        this.age = -1;
    }

    //4.name, salary, position, department, age
    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
        this.email = "n/a";
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
