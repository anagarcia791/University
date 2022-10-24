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
        this.instructorList.add(instructor);
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public void addSubject(Subject subject) {
        this.subjectList.add(subject);
    }

    public void addUniversityMember(UniversityMember universityMember) {
        this.universityMemberList.add(universityMember);
    }

    public Instructor getInstructorByIndex(int index) {
        Instructor instructor = new Instructor() {
            @Override
            public double salaryCalculation(Double baseSalary) {
                return 0;
            }
        };
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
                    addInstructor(newInstructor);
                    return fullName + " added as new instructor";
                case 2:
                    newInstructor = new PartTimeInstructor(fullName, username, baseSalary, experienceOrActiveHrs);
                    addInstructor(newInstructor);
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
            addStudent(newStudent);
            return fullName + " added as new student";
        }

        return "Username already exists";
    }

    public String createNewSubject(String subjectName, int instructorIndex) {
        if (checkIfSubjectExists(subjectName) &&
                getInstructorByIndex(instructorIndex).getBaseSalary() != null) {

            Subject newSubject = new Subject(subjectName, getInstructorByIndex(instructorIndex));
            addSubject(newSubject);

            return "New subject " + "'" + subjectName + "'" + " successfully created";
        }
        return "Check the given information for create a new subject";
    }

    public String addSubjectStudentByIndex(int subjectIndex, int studentIndex) {
        if (getSubjectByIndex(subjectIndex).getSubjectName() != null
                && getStudentByIndex(studentIndex).getStudentId() != null) {

            getSubjectByIndex(subjectIndex).addSubjectStudent(getStudentByIndex(studentIndex));

            return "Student with id " + getStudentByIndex(studentIndex).getStudentId() +
                    " added to " + getSubjectByIndex(subjectIndex).getSubjectName();

        }
        return "Check the subject or student id";
    }
}
