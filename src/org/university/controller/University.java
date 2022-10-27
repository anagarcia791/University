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

    public boolean checkIfUsernameExists(String username) {
        List<UniversityMember> memberList =
                this.universityMemberList.stream().
                        filter(member -> username.equalsIgnoreCase(member.getUsername())).collect(Collectors.toList());

        return memberList.size() == 0;
    }

    public boolean checkIfSubjectExists(String subjectName) {
        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subjectName.equalsIgnoreCase(subject.getSubjectName())).collect(Collectors.toList());

        return subjectList.size() == 0;
    }

    public void addUniversityMember(UniversityMember universityMember) {
        this.universityMemberList.add(universityMember);
    }

    public String createNewInstructor(String fullName, String username, Double baseSalary, Integer experienceOrActiveHrs, int instructorType) {
        String newInstructorResult = "Username already exists";

        if (checkIfUsernameExists(username)) {
            Instructor newInstructor;
            switch (instructorType) {
                case 1:
                    newInstructor = new FullTimeInstructor(fullName, username, baseSalary, experienceOrActiveHrs);
                    this.instructorList.add(newInstructor);
                    addUniversityMember(newInstructor);
                    newInstructorResult = fullName + " added as new full time instructor";
                    break;
                case 2:
                    newInstructor = new PartTimeInstructor(fullName, username, baseSalary, experienceOrActiveHrs);
                    this.instructorList.add(newInstructor);
                    addUniversityMember(newInstructor);
                    newInstructorResult = fullName + " added as new part time instructor";
                    break;
                default:
                    newInstructorResult = "Check the given information for create a new instructor";
                    break;
            }
        }

        return newInstructorResult;
    }

    public String createNewStudent(String fullName, String username, Integer studentAge) {
        String newStudentResult = "Username already exists";

        if (checkIfUsernameExists(username)) {
            Student newStudent = new Student(fullName, username, studentAge);
            this.studentList.add(newStudent);
            addUniversityMember(newStudent);
            newStudentResult = fullName + " added as new student";
        }

        return newStudentResult;
    }

    public String createNewSubject(String subjectName, int instructorId) {
        String newSubjectResult = "The subject already exists, or the id is incorrect";

        Instructor instructor = getInstructorById(instructorId);

        if (checkIfSubjectExists(subjectName) && instructor.getInstructorId() != null) {
            Subject newSubject = new Subject(subjectName, instructor);
            this.subjectList.add(newSubject);

            newSubjectResult = "New subject " + "'" + subjectName + "'" + " successfully created";
        }

        return newSubjectResult;
    }

    public String getSubjectDetails(int subjectId) {
        Subject subject = getSubjectById(subjectId);

        String subjectsDetail = "The id is incorrect";

        if (subject.getSubjectId() != null) {
            String instructorUsername = subject.getInstructorUsername();
            String subjectStudents = subject.getSubjectStudents();

            subjectsDetail =
                    "Instructor: " + instructorUsername + "\n" + "Students: ⤵" + "\n" + subjectStudents;
        }

        return subjectsDetail;
    }

    public String getStudentEnrolledSubjectsList(Student student) {
        String subjectsByStudent = "";

        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subject.studentIsEnrolledInSubject(student)).collect(Collectors.toList());

        for (Subject subject : subjectList) {
            subjectsByStudent += " - " + subject.getSubjectName();
        }

        return subjectsByStudent;
    }

    public String getStudentEnrolledSubjects(int studentId) {
        Student student = getStudentById(studentId);

        String subjectsByStudentId = "The id is incorrect";

        if (student.getStudentId() != null) {
            subjectsByStudentId = getStudentEnrolledSubjectsList(student);

            if (subjectsByStudentId.length() == 0) {
                subjectsByStudentId = student.getUsername() + " doesn't have subjects enrolled";
            } else {
                subjectsByStudentId = "Subjects enrolled for " + student.getUsername() + ": " + subjectsByStudentId;
            }

        }

        return subjectsByStudentId;
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
}
