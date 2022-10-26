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
        return ((super.baseSalary / 192) * (this.activeHoursPerMonth));
    }

    @Override
    public String toString() {
        return "Instructor Id: " + super.instructorId +
                ". | Part time | -> " +
                " Name: " + super.fullName +
                " - Username: " + super.username +
                " - Base salary: " + super.baseSalary +
                " - Active hrs month: " + this.activeHoursPerMonth +
                " - Monthly salary: " + String.format("%,.1f", salaryCalculation());
    }
}
