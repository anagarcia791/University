package org.university.controller;

import org.university.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public int getInstructorListSize() {
        return instructorList.size();
    }

    public int getStudentListSize() {
        return studentList.size();
    }

    public int getSubjectListSize() {
        return subjectList.size();
    }

    public Instructor getInstructorByIndex(int index) {
        Instructor instructor = new FullTimeInstructor();
        try {
            return this.instructorList.get(index);
        } catch (Exception ex) {
            return instructor;
        }
    }

    public Student getStudentByIndex(int index) {
        Student student = new Student();
        try {
            return this.studentList.get(index);
        } catch (Exception ex) {
            return student;
        }
    }

    public Subject getSubjectByIndex(int index) {
        Subject subject = new Subject();
        try {
            return this.subjectList.get(index);
        } catch (Exception ex) {
            return subject;
        }
    }

    public void addUniversityMember(UniversityMember universityMember) {
        this.universityMemberList.add(universityMember);
    }

    public boolean checkIfUsernameExists(String username) {
        List<UniversityMember> memberList =
                this.universityMemberList.stream().
                        filter(member -> username.equals(member.getUsername())).collect(Collectors.toList());

        return memberList.size() == 0;
    }

    public boolean checkIfSubjectExists(String subjectName) {
        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subjectName.equals(subject.getSubjectName())).collect(Collectors.toList());

        return subjectList.size() == 0;
    }

    public String createNewInstructor(String fullName, String username, Double baseSalary, Integer experienceOrActiveHrs, int instructorType) {
        if (checkIfUsernameExists(username)) {
            Instructor newInstructor;
            switch (instructorType) {
                case 1:
                    newInstructor = new FullTimeInstructor(fullName, username, baseSalary, experienceOrActiveHrs);
                    this.instructorList.add(newInstructor);
                    return fullName + " added as new instructor";
                case 2:
                    newInstructor = new PartTimeInstructor(fullName, username, baseSalary, experienceOrActiveHrs);
                    this.instructorList.add(newInstructor);
                    return fullName + " added as new instructor";
                default:
                    return "Check the given information for create a new instructor";
            }
        }

        return "Username already exists";
    }

    public String createNewStudent(String fullName, String username, Integer studentAge) {
        if (checkIfUsernameExists(username)) {
            Student newStudent = new Student(fullName, username, studentAge);
            this.studentList.add(newStudent);
            return fullName + " added as new student";
        }

        return "Username already exists";
    }

    public String createNewSubject(String subjectName, int instructorIndex) {
        if (checkIfSubjectExists(subjectName) &&
                getInstructorByIndex(instructorIndex).getInstructorId() != null) {

            Subject newSubject = new Subject(subjectName, getInstructorByIndex(instructorIndex));
            this.subjectList.add(newSubject);

            return "New subject " + "'" + subjectName + "'" + " successfully created";
        }
        return "The subject already exists, or the id is incorrect";
    }

    public String addSubjectStudentByIndex(int subjectIndex, int studentIndex) {
        if (getSubjectByIndex(subjectIndex).getSubjectName() != null
                && getStudentByIndex(studentIndex).getStudentId() != null) {

            return getSubjectByIndex(subjectIndex).addSubjectStudent(getStudentByIndex(studentIndex));

        }
        return "Check the subject or student id";
    }

    public String getStudentEnrolledSubjects(int studentIndex) {
        Student student = getStudentByIndex(studentIndex);

        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subject.isEnrolledInSubject(student)).collect(Collectors.toList());

        String subjectsByStudentId = "";

        for (Subject subject : subjectList) {
            subjectsByStudentId += " - " + subject.getSubjectName();
        }

        if(subjectsByStudentId.length() == 0){
            subjectsByStudentId = "No subjects enrolled";
            return subjectsByStudentId;
        }else{
            return "Subjects enrolled: " + subjectsByStudentId;
        }
    }
}
