package org.university.data;

public class PartTimeInstructor extends Instructor {
    // attributes
    private Integer activeHoursPerMonth;

    // constructor
    public PartTimeInstructor() {}
    public PartTimeInstructor(String fullName, String username, Double baseSalary, Integer activeHoursPerMonth) {
        super(fullName, username, baseSalary);
        this.activeHoursPerMonth = activeHoursPerMonth;
    }

    // methods
    public double salaryCalculation(Double baseSalary) {
        return ((baseSalary / 192) * (this.activeHoursPerMonth));
    }
}
