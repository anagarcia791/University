package org.university.view;

import org.university.data.*;
import org.university.persistence.DataInitializer;
import org.university.controller.University;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selectedOption = 0;

        University university = DataInitializer.loadUniversity();

        System.out.println("\n «« Welcome to " + university.getUniversityName() + " University »» ");

        int EXIT_OPTION = 9;

        do {
            selectedOption = 0;

            displayApplicationOptions();

            try {
                String selectedOptionStr = scan.nextLine();
                selectedOption = Integer.parseInt(selectedOptionStr);
            } catch (java.lang.NumberFormatException e) {
                System.out.println(tryAgainMessage());
            }

            if (selectedOption >= 1 && selectedOption <= EXIT_OPTION) {
                switch (selectedOption) {
                    case 1:
                        displayInstructorsData(university);
                        break;
                    case 2:
                        displayStudentsData(university);
                        break;
                    case 3:
                        displaySubjectsData(university);
                        break;
                    case 4:
                        displayUniversityMemberData(university);
                        break;
                    case 5:
                        searchSubjectsByStudentId(university);
                        break;
                    case 6:
                        triggerCreateNewStudent(university);
                        break;
                    case 7:
                        triggerCreateNewSubject(university);
                        break;
                    case 8:
                        triggerAddSubjectStudentByIndex(university);
                        break;
                }
            }

            if (selectedOption > EXIT_OPTION) {
                System.out.println(tryAgainMessage());
            }

        } while (selectedOption != EXIT_OPTION);
    }

    private static void displayApplicationOptions() {
        System.out.println("\n Choose one option : \n" +
                " 1. Print instructor's data \n" +
                " 2. Print student's data \n" +
                " 3. Print university's subjects \n" +
                " 4. Print university's members \n" +
                " 5. Search enrolled subjects, by student id \n" +
                " 6. Create new student \n" +
                " 7. Create new subject \n" +
                " 8. Add student to a subject \n" +
                " 9. Exit \n");
    }

    private static String tryAgainMessage() {
        return "-------- Incorrect option --------\t" + "\n    ⚠️    Try again       ⚠️    \n";
    }

    private static String noElementsMessage() {
        return "\n            No available elements            ";
    }

    private static String comingBackMessage() {
        return ">>>>>>>>> Coming back to principal menu <<<<<<<<<";
    }

    private static void displayInstructorsData(University university) {
        System.out.println("**** \uD83D\uDC69\u200D\uD83C\uDFEB **** Instructor's data **** \uD83D\uDC68\u200D\uD83C\uDFEB ****\t");

        if (university.getInstructorList().size() == 0) {
            System.out.println(noElementsMessage());
        }

        for (Instructor instructor : university.getInstructorList()) {
            System.out.println("\n" + "Name: " + instructor.getFullName() + " - Username: " + instructor.getUsername() +
                    " - Monthly salary: " +
                    String.format("%,.2f", instructor.salaryCalculation(instructor.getBaseSalary())));
        }

        System.out.println("\n" + comingBackMessage());
    }

    private static void displayStudentsData(University university) {
        System.out.println("**** \uD83D\uDC69\u200D\uD83C\uDF93 **** Student's data **** \uD83D\uDC68\u200D\uD83C\uDF93 ****\t");

        if (university.getStudentList().size() == 0) {
            System.out.println(noElementsMessage());
        }

        for (Student student : university.getStudentList()) {
            System.out.println("\n" + "Id: " + student.getStudentId() + " - Name: " + student.getFullName() +
                    " - Username: " + student.getUsername() + " - Age: " + student.getStudentAge());
        }

        System.out.println("\n" + comingBackMessage());
    }

    private static void displaySubjectsData(University university) {
        System.out.println("**** ✍ **** University's subjects **** ✍ ****\t");

        if (university.getSubjectList().size() == 0) {
            System.out.println(noElementsMessage());
        }

        int index = 0;

        for (Subject subject : university.getSubjectList()) {
            System.out.println("\n" + ++index + ". Subject: " + subject.getSubjectName() + " - Classroom: " + subject.getClassroom() +
                    " - Instructor: " + subject.getSubjectInstructorName());
        }
    }

    private static void displayUniversityMemberData(University university) {
        System.out.println("**** \uD83D\uDC69 **** University's members **** \uD83D\uDC68 ****\t");

        if (university.getUniversityMemberList().size() == 0) {
            System.out.println(noElementsMessage());
        }

        for (UniversityMember member : university.getUniversityMemberList()) {
            System.out.println("\n" + "Name: " + member.getFullName() + " - Username: " + member.getUsername());
        }

        System.out.println("\n" + comingBackMessage());
    }

    private static void searchSubjectsByStudentId(University university) {
        System.out.println("**** \uD83E\uDD13 **** Subjects in which student is enrolled **** \uD83E\uDD13 ****\t");
        System.out.println("\n" + comingBackMessage());
    }

    private static void triggerCreateNewStudent(University university){
        System.out.println("**** \uD83D\uDE00 **** Section for create new student **** \uD83D\uDE00 ****\t");
        System.out.println("\n" + comingBackMessage());
    }

    private static void triggerCreateNewSubject(University university){
        System.out.println("**** \uD83D\uDCDA **** Section for create new subject **** \uD83D\uDCDA ****\t");
        System.out.println("\n" + comingBackMessage());
    }

    private static void triggerAddSubjectStudentByIndex(University university){
        System.out.println("**** ✏ **** Section for add student to a subject **** ✏ ****\t");
        System.out.println("\n" + comingBackMessage());
    }

}