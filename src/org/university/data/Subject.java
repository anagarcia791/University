package org.university.data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    // attributes
    private final String subjectName;
    private final String classroom;
    private static Integer classroomInt = 0;
    private final Instructor subjectInstructor;
    private final List<Student> subjectStudentList;

    // constructor
    public Subject(String subjectName, Instructor subjectInstructor) {
        this.subjectName = subjectName;
        this.classroom = "A-" + ++classroomInt;
        this.subjectInstructor = subjectInstructor;
        this.subjectStudentList = new ArrayList<>();
    }

    // methods
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
