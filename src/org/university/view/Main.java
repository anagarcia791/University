package org.university.view;

import org.university.controller.University;
import org.university.persistence.DataInitializer;

public class Main {
    public static void main(String[] args) {
        University university = DataInitializer.loadUniversity();

        System.out.println("\n");
        System.out.println(university.getUniversityName());
        System.out.println("\n--------\n");

        System.out.println(university.getInstructorList());
        System.out.println("\n--------\n");

        System.out.println(university.getStudentList());
        System.out.println("\n--------\n");

        System.out.println(university.getSubjectList());
        System.out.println("\n--------\n");

        System.out.println(university.getUniversityMemberList());
    }
}