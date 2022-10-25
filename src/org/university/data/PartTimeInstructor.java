package org.university.data;

public class PartTimeInstructor extends Instructor {
    // attributes
    private final Integer activeHoursPerMonth;

    // constructor
    public PartTimeInstructor(String fullName, String username, Double baseSalary, Integer activeHoursPerMonth) {
        super(fullName, username, baseSalary);
        this.activeHoursPerMonth = activeHoursPerMonth;
    }

    // methods
    public double salaryCalculation() {
        return ((this.baseSalary / 192) * (this.activeHoursPerMonth));
    }

    @Override
    public String toString() {
        return "Part time instructor -> " +
                " Name: " + this.fullName +
                " - Username: " + this.username +
                " - Base salary: " + this.baseSalary +
                " - Active hrs month: " + this.activeHoursPerMonth +
                " - Monthly salary: " + String.format("%,.1f", salaryCalculation());
    }
}
