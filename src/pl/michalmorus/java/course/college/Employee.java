package pl.michalmorus.java.course.college;

public class Employee extends Person {

    private double salary;

    public Employee(String name, String surname, double salary) {
        super(name, surname);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }

    @Override
    PersonType getPersonType() {
        return PersonType.EMPLOYEE;
    }
}
