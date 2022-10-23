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
    public Subject() {}

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

    public void addSubjectStudent(Student student) {
        if(!this.subjectStudentList.contains(student)){
            this.subjectStudentList.add(student);
        }
    }

    @Override
    public String toString() {
        return "\n" + "subjectName = " + subjectName +
                ", classroom = " + classroom +
                ", subjectInstructor = " + subjectInstructor +
                ", subjectStudentList = " + subjectStudentList;
    }
}
