package org.university.persistence;

import org.university.controller.University;

public class DataInitializer {
    public static University loadUniversity() {
        University university = new University("EAN");

        loadInstructorsIntoUniversity(university);

        loadStudentIntoUniversity(university);

        loadSubjectsIntoUniversity(university);

        loadStudentsIntoEachSubject(university);

        return university;
    }

    private static void loadInstructorsIntoUniversity(University university) {
        university.createNewInstructor("Camilo Vargas", "c.vargas", 200.0, 5, 1);
        university.createNewInstructor("Paula Bula", "p.bula", 200.0, 7, 1);
        university.createNewInstructor("Enrique Giles", "e.giles", 200.0, 96, 2);
        university.createNewInstructor("Angela Parrado", "a.parrado", 200.0, 105, 2);
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
        university.createNewSubject("Microeconomics", 104);
        university.createNewSubject("Econometrics", 101);
        university.createNewSubject("Macroeconomics", 103);
        university.createNewSubject("History", 102);
    }

    private static void loadStudentsIntoEachSubject(University university) {
        university.addSubjectStudentById(301, 201);
        university.addSubjectStudentById(301, 202);
        university.addSubjectStudentById(301, 203);

        university.addSubjectStudentById(302, 201);
        university.addSubjectStudentById(302, 202);
        university.addSubjectStudentById(302, 203);

        university.addSubjectStudentById(303, 204);
        university.addSubjectStudentById(303, 205);
        university.addSubjectStudentById(303, 206);

        university.addSubjectStudentById(304, 204);
        university.addSubjectStudentById(304, 205);
        university.addSubjectStudentById(304, 206);
    }

}
