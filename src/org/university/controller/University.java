package org.university.controller;

import org.university.data.*;

import java.util.ArrayList;
import java.util.List;

public class University {
    // attributes
    private final String universityName;
    private final List<Instructor> instructorList;
    private final List<Student> studentList;
    private final List<Subject> subjectList;
    private final List<UniversityMember> universityMemberList;

    // constructor
    public University(String universityName) {
        this.universityName = universityName;
        this.instructorList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
        this.universityMemberList = new ArrayList<>();
    }

    // methods
    public String getUniversityName() {
        return universityName;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public List<UniversityMember> getUniversityMemberList() {
        return universityMemberList;
    }

    public void addInstructor(Instructor instructor) {
        if(!this.instructorList.contains(instructor)){
            this.instructorList.add(instructor);
        }
    }

    public void addStudent(Student student) {
        if(!this.studentList.contains(student)){
            this.studentList.add(student);
        }
    }

    public void addSubject(Subject subject) {
        if(!this.subjectList.contains(subject)){
            this.subjectList.add(subject);
        }
    }

    public void addUniversityMember(UniversityMember universityMember) {
        this.universityMemberList.add(universityMember);
    }

    public Subject getSubjectByIndex(int index) {
        Subject subject = new Subject();
        try {
            return this.subjectList.get(index);
        }catch (Exception ex){
            return subject;
        }
    }

    public Student getStudentByIndex(int index) {
        Student student = new Student();
        try {
            return this.studentList.get(index);
        }catch (Exception ex){
            return student;
        }
    }

    public String addSubjectStudentByIndex(int subjectIndex, int studentIndex){
        if(getSubjectByIndex(subjectIndex).getSubjectName() != null
                && getStudentByIndex(studentIndex).getStudentId() != null){

            getSubjectByIndex(subjectIndex).addSubjectStudent(getStudentByIndex(studentIndex));

            return "Student with id " +  getStudentByIndex(studentIndex).getStudentId() +
                    " added to " + getSubjectByIndex(subjectIndex).getSubjectName();

        }
        return "Check the subject or student id";
    }
}
