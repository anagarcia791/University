package org.university.controller;

import org.university.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class initialize the attributes needed for
 * organize structures of instructors, students and
 * subjects of the university, and have a way to interact with them.
 */
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

    /**
     * This method return an Instructor object,
     * filtered by its id.
     *
     * @param instructorId instructor id for filter
     * @return Instructor object
     */
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

    /**
     * This method return a Student object,
     * filtered by its id.
     *
     * @param studentId student id for filter
     * @return Student object
     */
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

    /**
     * This method return a Subject object,
     * filtered by its id.
     *
     * @param subjectId subject id for filter
     * @return Subject object
     */
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

    /**
     * This method return a boolean, after
     * check if the username match with the
     * username of any university member.
     *
     * @param username username for evaluation
     * @return a boolean if username has a match in university members list
     */
    public boolean checkIfUsernameExists(String username) {
        List<UniversityMember> memberList =
                this.universityMemberList.stream().
                        filter(member -> username.equalsIgnoreCase(member.getUsername())).collect(Collectors.toList());

        return memberList.size() == 0;
    }

    /**
     * This method return a boolean, after
     * check if the subject name match with the
     * 'subjectName' of any subject.
     *
     * @param subjectName subject name for evaluation
     * @return a boolean if subject name has a match in subject list
     */
    public boolean checkIfSubjectExists(String subjectName) {
        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subjectName.equalsIgnoreCase(subject.getSubjectName())).collect(Collectors.toList());

        return subjectList.size() == 0;
    }

    /**
     * This method adds members to university
     * member list.
     *
     * @param universityMember university member for addition in the list
     */
    public void addUniversityMember(UniversityMember universityMember) {
        this.universityMemberList.add(universityMember);
    }

    /**
     * This method create a new Instructor, either
     * full time instructor or part-time instructor.
     * Here is validated if the username already exists.
     *
     * @param fullName              full name to create new instructor
     * @param username              username to create new instructor
     * @param baseSalary            base salary to create new instructor
     * @param experienceOrActiveHrs here you can write experience years or active hrs monthly to create new instructor
     * @param instructorType        instructor type has 2 possible options: 1. full time instructor or 2. part-time instructor
     * @return a String with message of: success or failed instructor creation
     */
    public String createNewInstructor(String fullName, String username, Double baseSalary, Integer experienceOrActiveHrs, int instructorType) {
        String newInstructorResult = "Username already exists";

        if (checkIfUsernameExists(username)) {
            newInstructorResult = "Check the given information for create a new instructor";

            if (baseSalary > 0 && experienceOrActiveHrs > 0) {
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

        }

        return newInstructorResult;
    }

    /**
     * This method create a new Student.
     * Here is validated if the username already exists.
     *
     * @param fullName   full name to create new student
     * @param username   username to create new student
     * @param studentAge student age to create new student
     * @return a String with message of: success or failed student creation
     */
    public String createNewStudent(String fullName, String username, Integer studentAge) {
        String newStudentResult = "Username already exists";

        if (checkIfUsernameExists(username)) {
            newStudentResult = "Check the given information for create a new student";

            if (studentAge > 0) {
                Student newStudent = new Student(fullName, username, studentAge);
                this.studentList.add(newStudent);
                addUniversityMember(newStudent);
                newStudentResult = fullName + " added as new student";
            }

        }

        return newStudentResult;
    }

    /**
     * This method create a new Subject.
     * Here is validated if the subject already exists,
     * and if the instructor id is correct.
     *
     * @param subjectName  subject name to create new subject
     * @param instructorId id of one instructor already created responsible for the new subject
     * @return a String with message of: success or failed subject creation
     */
    public String createNewSubject(String subjectName, int instructorId) {
        String newSubjectResult = "The subject already exists";

        Instructor instructor = getInstructorById(instructorId);

        if (checkIfSubjectExists(subjectName)) {
            newSubjectResult = "Check the given information for create a new subject";

            if (instructor.getInstructorId() != null) {
                Subject newSubject = new Subject(subjectName, instructor);
                this.subjectList.add(newSubject);

                newSubjectResult = "New subject " + "'" + subjectName + "'" + " successfully created";
            }

        }

        return newSubjectResult;
    }

    /**
     * This method check all available subjects, and look up
     * for those where the instructor in included.
     *
     * @param instructor a Instructor object for evaluation
     * @return a String empty or with the subjects where the instructor is included
     */
    public String getSubjectsGivenByInstructorList(Instructor instructor) {
        String subjectsByInstructor = "";

        List<Subject> subjectList =
                this.subjectList.stream().
                        filter(subject -> subject.instructorGivesTheSubject(instructor)).collect(Collectors.toList());


        for (Subject subject : subjectList) {
            subjectsByInstructor += " - " + subject.getSubjectName();
        }

        return subjectsByInstructor;
    }

    /**
     * This method uses getSubjectsGivenByInstructorList() method
     * for modularize the output message, where the instructor of
     * a subject is equal to the input.
     *
     * @param instructorId instructor id for search the complete object
     * @return a String with the subjects given by the instructor or error in the search
     */
    public String getSubjectsGivenByInstructor(int instructorId) {
        Instructor instructor = getInstructorById(instructorId);

        String subjectsGivenByInstructor = "The id is incorrect";

        if (instructor.getInstructorId() != null) {
            subjectsGivenByInstructor = getSubjectsGivenByInstructorList(instructor);

            if (subjectsGivenByInstructor.length() == 0) {
                subjectsGivenByInstructor = "The instructor " + instructor.getUsername() + " doesn't have subjects assigned";
            } else {
                subjectsGivenByInstructor = "Subjects given by " + instructor.getUsername() + ": " + subjectsGivenByInstructor;
            }

        }

        return subjectsGivenByInstructor;
    }

    /**
     * This method check all available subjects, and look up
     * for those where the student list of the subject includes
     * a student.
     *
     * @param student a Student object for evaluation
     * @return a String empty or with the subjects where the student is included
     */
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

    /**
     * This method uses getStudentEnrolledSubjectsList() method
     * for modularize the output message, where the student list of
     * a subject includes a student.
     *
     * @param studentId student id for search the complete object
     * @return a String with the subjects enrolled by the student or error in the search
     */
    public String getStudentEnrolledSubjects(int studentId) {
        Student student = getStudentById(studentId);

        String subjectsByStudentId = "The id is incorrect";

        if (student.getStudentId() != null) {
            subjectsByStudentId = getStudentEnrolledSubjectsList(student);

            if (subjectsByStudentId.length() == 0) {
                subjectsByStudentId = "The student " + student.getUsername() + " doesn't have subjects enrolled";
            } else {
                subjectsByStudentId = "Subjects enrolled for " + student.getUsername() + ": " + subjectsByStudentId;
            }

        }

        return subjectsByStudentId;
    }

    /**
     * This method return additional information for specific subject,
     * like instructor username, and id and username of students enrolled.
     *
     * @param subjectId id of subject to look up for information
     * @return a String with the subject details or error in the search
     */
    public String getSubjectDetails(int subjectId) {
        Subject subject = getSubjectById(subjectId);

        String subjectsDetail = "The id is incorrect";

        if (subject.getSubjectId() != null) {
            subjectsDetail =
                    "Instructor: " + subject.getInstructorUsername() + "\n" +
                            subject.getSubjectName() + "'s students: " +
                            subject.getSubjectStudents();
        }

        return subjectsDetail;
    }

    /**
     * This method trigger the addition of a student in a subject,
     * after confirm the ids corresponds to existing objects.
     *
     * @param subjectId subject id for search the complete object
     * @param studentId student id for search the complete object
     * @return a String with message of: success or failed addition process
     */
    public String addSubjectStudentById(int subjectId, int studentId) {
        Subject subject = getSubjectById(subjectId);
        Student student = getStudentById(studentId);

        if (subject.getSubjectName() != null && student.getStudentId() != null) {
            return subject.addSubjectStudent(student);
        } else {
            return "Check the subject and student id";
        }
    }
}
