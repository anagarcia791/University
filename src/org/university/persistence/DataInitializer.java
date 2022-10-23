package org.university.persistence;

import org.university.controller.University;
import org.university.data.*;

import java.util.List;

public class DataInitializer {
    public static University loadUniversity(){
        University university = new University("EAN");

        loadInstructorsIntoUniversity(university);

        loadStudentIntoUniversity(university);

        loadSubjectsIntoUniversity(university);

        loadStudentsIntoEachSubject(university);

        loadUniversityMembersIntoUniversity(university);

        return university;
    }

    private static void loadInstructorsIntoUniversity(University university){
        Instructor newInstructor = new FullTimeInstructor("Camilo Vargas", "c.vargas", 200.0, 5);
        university.addInstructor(newInstructor);

        newInstructor = new FullTimeInstructor("Paula Bula", "p.bula", 200.0, 7);
        university.addInstructor(newInstructor);

        newInstructor = new PartTimeInstructor("Enrique Giles", "e.giles", 200.0, 96);
        university.addInstructor(newInstructor);
    }

    private static void loadStudentIntoUniversity(University university){
        Student newStudent = new Student("Claudia Marin", "c.marin", 25);
        university.addStudent(newStudent);

        newStudent = new Student("David Gomez", "d.gomez", 24);
        university.addStudent(newStudent);

        newStudent = new Student("Alejandro Gomez", "a.gomez", 27);
        university.addStudent(newStudent);

        newStudent = new Student("Karen Almanzar", "k.almanzar", 24);
        university.addStudent(newStudent);

        newStudent = new Student("Juan Urdaneta", "j.urdaneta", 25);
        university.addStudent(newStudent);

        newStudent = new Student("Cristian Salguero", "c.salguero", 25);
        university.addStudent(newStudent);
    }

    private static void loadSubjectsIntoUniversity(University university){
        List<Instructor> instructorList = university.getInstructorList();

        Subject newSubject = new Subject("Microeconomics", instructorList.get(0));
        university.addSubject(newSubject);

        newSubject = new Subject("Macroeconomics", instructorList.get(2));
        university.addSubject(newSubject);

        newSubject = new Subject("History", instructorList.get(1));
        university.addSubject(newSubject);

        newSubject = new Subject("Econometrics", instructorList.get(0));
        university.addSubject(newSubject);
    }

    private static void loadStudentsIntoEachSubject(University university){
        List<Subject> subjectList = university.getSubjectList();
        List<Student> studentList = university.getStudentList();

        subjectList.get(0).addSubjectStudent(studentList.get(0));
        subjectList.get(0).addSubjectStudent(studentList.get(1));
        subjectList.get(0).addSubjectStudent(studentList.get(2));

        subjectList.get(1).addSubjectStudent(studentList.get(0));
        subjectList.get(1).addSubjectStudent(studentList.get(1));
        subjectList.get(1).addSubjectStudent(studentList.get(2));

        subjectList.get(2).addSubjectStudent(studentList.get(3));
        subjectList.get(2).addSubjectStudent(studentList.get(4));
        subjectList.get(2).addSubjectStudent(studentList.get(5));

        subjectList.get(3).addSubjectStudent(studentList.get(3));
        subjectList.get(3).addSubjectStudent(studentList.get(4));
        subjectList.get(3).addSubjectStudent(studentList.get(5));
    }

    private static void loadUniversityMembersIntoUniversity(University university){
        for (Instructor instructor : university.getInstructorList()) {
            university.addUniversityMember(instructor);
        }

        for (Student student : university.getStudentList()) {
            university.addUniversityMember(student);
        }
    }
}
