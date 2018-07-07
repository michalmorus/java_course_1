package pl.michalmorus.java.course.College;

import java.util.Arrays;

public class Student extends Person {

    private static double GRANT_LIMIT = 1.95;
    private static double SCHOLARSHIP_LIMIT = 4.75;

    private long indexNumber;
    private double[] ratings;
    private double avg;
    private boolean isGrantedToNextClass;
    private boolean hasScholarship;


    public Student(String name, String surname, long indexNumber, double[] ratings) {
        super(name, surname);
        this.indexNumber = indexNumber;
        this.ratings = ratings;
        this.avg = this.getRatingsAvg();
        this.isGrantedToNextClass = isGrantedToNextClass();
        this.hasScholarship = hasScholarship();
    }

    public long getIndexNumber() {
        return indexNumber;
    }

    public double[] getRatings() {
        return ratings;
    }

    public boolean isGrantedToNextClass() {
        return this.avg > GRANT_LIMIT;
    }

    public boolean hasScholarship() {
        return this.avg > SCHOLARSHIP_LIMIT;
    }

    private double getRatingsAvg() {
        double sum = 0;
        for (double v : this.ratings) {
            sum += v;
        }
        double avg = sum / this.ratings.length;

        return avg;
    }

    @Override
    PersonType getPersonType() {
        return PersonType.STUDENT;
    }

    @Override
    public String toString() {
        return "Student{" +
                "indexNumber=" + indexNumber +
                ", ratings=" + Arrays.toString(ratings) +
                ", avg=" + avg +
                ", isGrantedToNextClass=" + isGrantedToNextClass +
                ", hasScholarship=" + hasScholarship +
                '}';
    }
}
