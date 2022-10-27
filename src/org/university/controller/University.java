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
        return this.instructorList.get(index);
    }

    public Student getStudentByIndex(int index) {
        return this.studentList.get(index);
    }

    public Subject getSubjectByIndex(int index) {
        return this.subjectList.get(index);
    }

    public Instructor getInstructorById(int instructorId) {
        List<Instructor> instructorList =
                this.instructorList.stream().
                        filter(instructor -> instructorId == instructor.getInstructorId()).collect(Collectors.toList());

        if (instructorList.size() == 0) {
            return new FullTimeInstructor();
        } else {
            return instructorList.get(0);
        }
    }

    public Student getStudentById(int studentId) {
        List<Student> studentList =
                this.studentList.stream().
                        filter(student -> studentId == student.getStudentId()).collect(Collectors.toList());

        if (studentList.size() == 0) {
            return new Student();
        } else {
            return studentList.get(0);
        }
    }

    public Subject getSubjectById(int subjectId) {
        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subjectId == subject.getSubjectId()).collect(Collectors.toList());

        if (subjectList.size() == 0) {
            return new Subject();
        } else {
            return subjectList.get(0);
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
                    addUniversityMember(newInstructor);
                    return fullName + " added as new instructor";
                case 2:
                    newInstructor = new PartTimeInstructor(fullName, username, baseSalary, experienceOrActiveHrs);
                    this.instructorList.add(newInstructor);
                    addUniversityMember(newInstructor);
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
            addUniversityMember(newStudent);
            return fullName + " added as new student";
        }
        return "Username already exists";
    }

    public String createNewSubject(String subjectName, int instructorId) {
        Instructor instructor = getInstructorById(instructorId);

        if (checkIfSubjectExists(subjectName.trim()) && instructor.getInstructorId() != null) {
            Subject newSubject = new Subject(subjectName.trim(), instructor);
            this.subjectList.add(newSubject);

            return "New subject " + "'" + subjectName + "'" + " successfully created";
        } else {
            return "The subject already exists, or the id is incorrect";
        }
    }

    public String addSubjectStudentById(int subjectId, int studentId) {
        Subject subject = getSubjectById(subjectId);
        Student student = getStudentById(studentId);

        if (subject.getSubjectName() != null && student.getStudentId() != null) {
            return subject.addSubjectStudent(student);
        } else {
            return "Check the subject or student id";
        }
    }

    public String getSubjectDetails(int subjectId) {
        Subject subject = getSubjectById(subjectId);

        String instructorUsername = subject.getInstructorUsername();
        String subjectStudents = subject.getSubjectStudents();

        return "Instructor: " + instructorUsername + "\n" +
                "Students: ⤵" + "\n" + subjectStudents;
    }

    public String getStudentEnrolledSubjects(int studentId) {
        Student student = getStudentById(studentId);

        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subject.studentIsEnrolledInSubject(student)).collect(Collectors.toList());

        String subjectsByStudentId = "";

        for (Subject subject : subjectList) {
            subjectsByStudentId += " - " + subject.getSubjectName();
        }

        if (subjectsByStudentId.length() == 0) {
            subjectsByStudentId = student.getUsername() + " doesn't have subjects enrolled";
            return subjectsByStudentId;
        } else {
            return "Subjects enrolled for " + student.getUsername() + ": " + subjectsByStudentId;
        }
    }
}
