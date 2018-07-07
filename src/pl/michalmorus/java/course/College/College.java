package pl.michalmorus.java.course.College;

public class College {

    public static void run() {

        Person[] persons = new Person[7];
        persons[0] = new Student("Jan", "Kowalski", 99757, new double[]{1, 1, 1, 2});
        persons[1] = new Student("Marek", "Nowak", 99283, new double[]{5, 5, 5, 5});
        persons[2] = new Student("Adam", "Zieliński", 99211, new double[]{3, 1, 2, 3});
        persons[3] = new Student("Jakub", "Mazur", 99512, new double[]{4, 2, 1, 5});
        persons[4] = new Employee("Stanisław", "Kaczmarek", 2300);
        persons[5] = new Employee("Emil", "Grabowski", 4000);
        persons[6] = new Employee("Rafał", "Krawczyk", 3500);

        System.out.println("Lista osób");
        for (Person person : persons) {
            System.out.println(person.toString());
        }


        double salarySum = 0;
        int nonGrantedSum = 0;

        for (Person person : persons) {
            if (person.getPersonType() == PersonType.STUDENT && !((Student) person).isGrantedToNextClass()) {
                nonGrantedSum++;
            }
            if (person.getPersonType() == PersonType.EMPLOYEE) {
                salarySum += ((Employee) person).getSalary();
            }
        }

        System.out.println("Liczba powtarzających rok");
        System.out.println(nonGrantedSum);

        System.out.println("Suma zarobków");
        System.out.println(salarySum);
    }
}
