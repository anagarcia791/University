package org.university.persistence;

import org.university.controller.University;
import org.university.data.*;

import java.util.List;

public class DataInitializer {
    public static University loadUniversity() {
        University university = new University("EAN");

        loadInstructorsIntoUniversity(university);

        loadStudentIntoUniversity(university);

        loadSubjectsIntoUniversity(university);

        loadStudentsIntoEachSubject(university);

        loadUniversityMembersIntoUniversity(university);

        return university;
    }

    private static void loadInstructorsIntoUniversity(University university) {
        university.createNewInstructor("Camilo Vargas", "c.vargas", 200.0, 5, 1);
        university.createNewInstructor("Paula Bula", "p.bula", 200.0, 7, 1);
        university.createNewInstructor("Enrique Giles", "e.giles", 200.0, 96, 2);
    }

    private static void loadStudentIntoUniversity(University university) {
        university.createNewStudent("Claudia Marin", "c.marin", 25);
        university.createNewStudent("David Gomez", "d.gomez", 24);
        university.createNewStudent("Alejandro Gomez", "a.gomez", 27);
        university.createNewStudent("Karen Almanzar", "k.almanzar", 24);
        university.createNewStudent("Juan Urdaneta", "j.urdaneta", 25);
        university.createNewStudent("Cristian Salguero", "c.salguero", 25);
    }

    private static void loadSubjectsIntoUniversity(University university) {
        university.createNewSubject("Microeconomics", 0);
        university.createNewSubject("Macroeconomics", 2);
        university.createNewSubject("History", 1);
        university.createNewSubject("Econometrics", 0);
    }

    private static void loadStudentsIntoEachSubject(University university) {
        university.addSubjectStudentByIndex(0, 0);
        university.addSubjectStudentByIndex(0, 1);
        university.addSubjectStudentByIndex(0, 2);

        university.addSubjectStudentByIndex(1, 0);
        university.addSubjectStudentByIndex(1, 1);
        university.addSubjectStudentByIndex(1, 2);

        university.addSubjectStudentByIndex(2, 3);
        university.addSubjectStudentByIndex(2, 4);
        university.addSubjectStudentByIndex(2, 5);

        university.addSubjectStudentByIndex(3, 3);
        university.addSubjectStudentByIndex(3, 4);
        university.addSubjectStudentByIndex(3, 5);
    }

    private static void loadUniversityMembersIntoUniversity(University university) {
        for (Instructor instructor : university.getInstructorList()) {
            university.addUniversityMember(instructor);
        }

        for (Student student : university.getStudentList()) {
            university.addUniversityMember(student);
        }
    }
}
