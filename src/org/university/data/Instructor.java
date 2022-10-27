package org.university.data;

public abstract class Instructor extends UniversityMember {
    // attributes
    protected Integer instructorId;
    private static Integer instructorIdCount = 100;
    protected Double baseSalary;

    // constructor
    public Instructor() {
    }

    public Instructor(String fullName, String username, Double baseSalary) {
        super(fullName, username);
        this.instructorId = ++instructorIdCount;
        this.baseSalary = baseSalary;
    }

    // methods
    public Integer getInstructorId() {
        return instructorId;
    }

    public abstract double salaryCalculation();
}