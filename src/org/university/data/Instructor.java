package org.university.data;

public abstract class Instructor extends UniversityMember {
    // attributes
    protected Double baseSalary;

    // constructor
    public Instructor() {
    }

    public Instructor(String fullName, String username, Double baseSalary) {
        super(fullName, username);
        this.baseSalary = baseSalary;
    }

    // methods
    public Double getBaseSalary() {
        return baseSalary;
    }

    public abstract double salaryCalculation();
}