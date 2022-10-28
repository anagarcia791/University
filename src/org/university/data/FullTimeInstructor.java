package org.university.data;

/**
 * This class initialize the attributes needed for
 * create a new university full time instructor. Furthermore,
 * it's extending the abstract Instructor class.
 */
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
    /**
     * This method return the monthly salary, after
     * taking into account the total experience years of instructor.
     *
     * @return a double calculated with base salary and experience years
     */
    public double salaryCalculation() {
        return (super.baseSalary * (this.experienceYears * 1.1));
    }

    @Override
    public String toString() {
        return "Instructor Id: " + super.instructorId +
                ". | Full time | -> " +
                " Name: " + super.fullName +
                " - Username: " + super.username +
                " - Base salary: " + super.baseSalary +
                " - Experience years: " + this.experienceYears +
                " - Monthly salary: " + String.format("%,.1f", salaryCalculation());
    }
}