package pl.michalmorus.java.course.college;

abstract class Person {
    private String name;
    private String surname;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    abstract PersonType getPersonType();

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
