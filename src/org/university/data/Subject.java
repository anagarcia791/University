package org.university.data;

import java.util.ArrayList;
import java.util.List;

/**
 * This class initialize the attributes needed for
 * create a new university subject.
 */
public class Subject {
    // attributes
    private Integer subjectId;
    private static Integer count = 0;
    private String subjectName;
    private String classroom;
    private Instructor subjectInstructor;
    private List<Student> subjectStudentList;

    // constructor
    public Subject() {
    }

    public Subject(String subjectName, Instructor subjectInstructor) {
        this.subjectId = 300 + (++count);
        this.subjectName = subjectName;
        this.classroom = "A-" + count;
        this.subjectInstructor = subjectInstructor;
        this.subjectStudentList = new ArrayList<>();
    }

    // methods
    public Integer getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getInstructorUsername() {
        return this.subjectInstructor.getUsername();
    }

    /**
     * This method return boolean after evaluation of
     * instructor inside Subject object.
     *
     * @param instructor a Instructor object for evaluation
     * @return boolean according if instructor is the same of the instructor in Subject object
     */
    public boolean instructorGivesTheSubject(Instructor instructor) {
        return this.subjectInstructor == instructor;
    }

    /**
     * This method return boolean after evaluation of
     * student containment inside list of students.
     *
     * @param student a Student object for evaluation
     * @return boolean according containment of the student inside students list of subject
     */
    public boolean studentIsEnrolledInSubject(Student student) {
        return this.subjectStudentList.contains(student);
    }

    /**
     * This method return students enrolled in a specific subject,
     * it checks the subject student list to give id and username
     * for each one in the list.
     *
     * @return a String with the students enrolled in the subject
     */
    public String getSubjectStudents() {
        String subjectStudents = "";

        if (this.subjectStudentList.size() == 0) {
            subjectStudents = " No students enrolled";
        }

        for (Student student : this.subjectStudentList) {
            subjectStudents += " - Id: " + student.getStudentId() + " Username: " + student.getUsername();
        }

        return subjectStudents;
    }

    /**
     * This method return a message according if the student
     * is already enrolled in subject or is just added.
     *
     * @param student a Student object for aggregate it to a subject
     * @return a String with message of: success or failed aggregation process
     */
    public String addSubjectStudent(Student student) {
        String studentAggregationResult =
                "Student with id " + student.getStudentId() + " is already enrolled in " + this.subjectName + " subject";

        if (!this.subjectStudentList.contains(student)) {
            this.subjectStudentList.add(student);
            studentAggregationResult = "Student with id " + student.getStudentId() + " added to " + this.subjectName;
        }

        return studentAggregationResult;
    }

    @Override
    public String toString() {
        return "Subject Id: " + this.subjectId + ". - Subject: " + this.subjectName +
                " - Classroom: " + this.classroom;
    }
}
