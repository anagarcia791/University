package org.university.data;

public class FullTimeInstructor extends Instructor {
    // attributes
    private Integer experienceYears;

    // constructor
    public FullTimeInstructor() {
    }

    public FullTimeInstructor(String fullName, String username, Double baseSalary, Integer experienceYears) {
        super(fullName, username, baseSalary);
        this.experienceYears = experienceYears;
    }

    // methods
    public double salaryCalculation() {
        return (this.baseSalary * (this.experienceYears * 1.1));
    }

    @Override
    public String toString() {
        return "Full time instructor -> " +
                " Name: " + this.fullName +
                " - Username: " + this.username +
                " - Base salary: " + this.baseSalary +
                " - Experience years: " + this.experienceYears +
                " - Monthly salary: " + String.format("%,.1f", salaryCalculation());
    }
}
