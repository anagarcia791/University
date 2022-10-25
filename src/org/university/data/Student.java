package org.university.data;

public class Student extends UniversityMember {
    // attributes
    private Integer studentId;
    private static Integer studentIdCount = 0;
    private Integer studentAge;

    // constructor
    public Student() {
    }

    public Student(String fullName, String username, Integer studentAge) {
        super(fullName, username);
        this.studentId = ++studentIdCount;
        this.studentAge = studentAge;
    }

    // methods
    public Integer getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Id: " + this.studentId + " - Name: " + this.fullName + " - Username: " + this.username + " - Age: " + this.studentAge;
    }
}
