package org.university.data;

/**
 * This class initialize the attributes needed for
 * create a new university part-time instructor. Furthermore,
 * it's extending the abstract Instructor class.
 */
public class PartTimeInstructor extends Instructor {
    // attributes
    private final Integer activeHoursPerMonth;

    // constructor
    public PartTimeInstructor(String fullName, String username, Double baseSalary, Integer activeHoursPerMonth) {
        super(fullName, username, baseSalary);
        this.activeHoursPerMonth = activeHoursPerMonth;
    }

    // methods
    /**
     * This method return the monthly salary, after
     * taking into account the total monthly hrs worked.
     *
     * @return a double calculated with base salary and active hrs per month
     */
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
