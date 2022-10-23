package org.university.data;

public class FullTimeInstructor extends Instructor {
    // attributes
    private final Integer experienceYears;

    // constructor
    public FullTimeInstructor(String fullName, String username, Double baseSalary, Integer experienceYears) {
        super(fullName, username, baseSalary);
        this.experienceYears = experienceYears;
    }

    // methods
    public double salaryCalculation(Double baseSalary) {
        return (baseSalary * (this.experienceYears * 1.1));
    }
}
