package org.university.data;

public class Student extends UniversityMember {
    // attributes
    private final Integer studentId;
    private static Integer studentIdCount = 0;
    private final Integer studentAge;

    // constructor
    public Student(String fullName, String username, Integer studentAge) {
        super(fullName, username);
        this.studentId = ++studentIdCount;
        this.studentAge = studentAge;
    }

    // methods
}
