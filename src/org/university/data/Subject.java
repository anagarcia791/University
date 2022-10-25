package org.university.data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    // attributes
    private String subjectName;
    private String classroom;
    private static Integer classroomInt = 0;
    private Instructor subjectInstructor;
    private List<Student> subjectStudentList;

    // constructor
    public Subject() {
    }

    public Subject(String subjectName, Instructor subjectInstructor) {
        this.subjectName = subjectName;
        this.classroom = "A-" + ++classroomInt;
        this.subjectInstructor = subjectInstructor;
        this.subjectStudentList = new ArrayList<>();
    }

    // methods
    public String getSubjectName() {
        return subjectName;
    }

    public String addSubjectStudent(Student student) {
        if (!this.subjectStudentList.contains(student)) {
            this.subjectStudentList.add(student);
            return "Student with id " + student.getStudentId() + " added to " + this.subjectName;
        }
        return "Student with id " + student.getStudentId() + " is already enrolled in " + this.subjectName + " subject";
    }

    @Override
    public String toString() {
        return "Subject: " + this.subjectName + " - Classroom: " + this.classroom +
                " - Instructor: " + subjectInstructor.fullName;
    }
}
