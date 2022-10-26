package org.university.data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    // attributes
    private Integer subjectId;
    private static Integer subjectIdCount = 0;
    private String subjectName;
    private String classroom;
    private Instructor subjectInstructor;
    private List<Student> subjectStudentList;

    // constructor
    public Subject() {
    }

    public Subject(String subjectName, Instructor subjectInstructor) {
        this.subjectId = ++subjectIdCount;
        this.subjectName = subjectName;
        this.classroom = "A-" + subjectIdCount;
        this.subjectInstructor = subjectInstructor;
        this.subjectStudentList = new ArrayList<>();
    }

    // methods
    public String getSubjectName() {
        return subjectName;
    }

    public String getInstructorUsername() {
        return this.subjectInstructor.getUsername();
    }

    public String getSubjectStudents() {
        String subjectStudents = "";

        if (this.subjectStudentList.size() == 0) {
            subjectStudents = "No students enrolled";
        }

        for (Student student : this.subjectStudentList) {
            subjectStudents += " - Id: " + student.getStudentId() + " Username: " + student.getUsername();
        }

        return subjectStudents;
    }

    public String addSubjectStudent(Student student) {
        if (!this.subjectStudentList.contains(student)) {
            this.subjectStudentList.add(student);
            return "Student with id " + student.getStudentId() + " added to " + this.subjectName;
        }
        return "Student with id " + student.getStudentId() + " is already enrolled in " + this.subjectName + " subject";
    }

    public boolean isEnrolledInSubject(Student student) {
        return this.subjectStudentList.contains(student);
    }

    @Override
    public String toString() {
        return "Subject Id: " + this.subjectId + " - Subject: " + this.subjectName +
                " - Classroom: " + this.classroom;
    }
}
