package org.university.view;

import org.university.persistence.DataInitializer;
import org.university.controller.University;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selectedOption = 0;

        University university = DataInitializer.loadUniversity();

        System.out.println("\n «« Welcome to " + university.getUniversityName() + " University »» ");

        int EXIT_OPTION = 8;

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
                        triggerCreateNewInstructor(university);
                        break;
                    case 5:
                        triggerCreateNewStudent(university);
                        break;
                    case 6:
                        triggerCreateNewSubject(university);
                        break;
                    case 7:
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
                " 3. Print university's subjects data \n" +
                " 4. Create new instructor \n" +
                " 5. Create new student \n" +
                " 6. Create new subject \n" +
                " 7. Add student to a subject \n" +
                " 8. Exit \n");
    }

    private static String tryAgainMessage() {
        return "-------- Incorrect option --------\t" + "\n    ⚠️    Try again       ⚠️    \n";
    }

    private static String noElementsMessage() {
        return "\n            No available elements            ";
    }

    private static String errorMessage() {
        return "\n       ❗       Error occurred       ❗       ";
    }

    private static String invalidNumber() {
        return "Input number is invalid";
    }

    private static String invalidInputs() {
        return "Please Type valid info in all fields";
    }

    private static String comingBackMessage() {
        return ">>>>>>>>> Coming back to principal menu <<<<<<<<<";
    }

    /**
     * This method get all instructor data to display it.
     *
     * @param university University object for look up information
     */
    private static void displayInstructorsData(University university) {
        System.out.println("**** \uD83D\uDC69\u200D\uD83C\uDFEB **** Instructor's data **** \uD83D\uDC68\u200D\uD83C\uDFEB ****\n");

        if (university.getInstructorListSize() == 0) {
            System.out.println(noElementsMessage());
        }

        for (int i = 0; i < university.getInstructorListSize(); i++) {
            System.out.println(university.getInstructorByIndex(i));
        }

        getInstructorSubjects(university);
    }

    /**
     * This method get the subjects given by an instructor by instructor id.
     *
     * @param university University object for look up information
     */
    private static void getInstructorSubjects(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n❊ \uD83D\uDC40 ❊ If you want to check subjects given by specific instructor ❊ \uD83D\uDC40 ❊\t");
        System.out.println("              type the instructor id below, or type 0 to exit \n");

        int instructorId = 0;

        try {
            instructorId = scan.nextInt();
        } catch (Exception ex) {
            System.out.println(errorMessage());
        }

        if (instructorId > 0) {
            System.out.println(university.getSubjectsGivenByInstructor(instructorId));
        } else if (instructorId < 0) {
            System.out.println(invalidNumber());
        }

        System.out.println("\n" + comingBackMessage());
    }

    /**
     * This method get all students data to display it.
     *
     * @param university University object for look up information
     */
    private static void displayStudentsData(University university) {
        System.out.println("**** \uD83D\uDC69\u200D\uD83C\uDF93 **** Student's data **** \uD83D\uDC68\u200D\uD83C\uDF93 ****\n");

        if (university.getStudentListSize() == 0) {
            System.out.println(noElementsMessage());
        }

        for (int i = 0; i < university.getStudentListSize(); i++) {
            System.out.println(university.getStudentByIndex(i));
        }

        getStudentEnrolledSubjectsByStudentId(university);
    }

    /**
     * This method get the subjects enrolled by student id.
     *
     * @param university University object for look up information
     */
    private static void getStudentEnrolledSubjectsByStudentId(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n❊ \uD83D\uDC40 ❊ If you want to check the subjects in which student is enrolled ❊ \uD83D\uDC40 ❊\t");
        System.out.println("                type the student id below, or type 0 to exit \n");

        int studentId = 0;

        try {
            studentId = scan.nextInt();
        } catch (Exception ex) {
            System.out.println(errorMessage());
        }

        if (studentId > 0) {
            System.out.println(university.getStudentEnrolledSubjects(studentId));
        } else if (studentId < 0) {
            System.out.println(invalidNumber());
        }

        System.out.println("\n" + comingBackMessage());
    }

    /**
     * This method get all subjects data to display it.
     *
     * @param university University object for look up information
     */
    private static void displaySubjectsData(University university) {
        System.out.println("**** ✍ **** University's subjects **** ✍ ****\n");

        if (university.getSubjectListSize() == 0) {
            System.out.println(noElementsMessage());
        }

        for (int i = 0; i < university.getSubjectListSize(); i++) {
            System.out.println(university.getSubjectByIndex(i));
        }

        getSubjectDetail(university);
    }

    /**
     * This method get additional information for a subject.
     *
     * @param university University object for look up information
     */
    private static void getSubjectDetail(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n❊ \uD83D\uDC40 ❊ If you want to check details of any subject ❊ \uD83D\uDC40 ❊\t");
        System.out.println("        type the subject id below, or type 0 to exit \n");

        int subjectId = 0;

        try {
            subjectId = scan.nextInt();
        } catch (Exception ex) {
            System.out.println(errorMessage());
        }

        if (subjectId > 0) {
            System.out.println(university.getSubjectDetails(subjectId));
        } else if (subjectId < 0) {
            System.out.println(invalidNumber());
        }

        System.out.println("\n" + comingBackMessage());
    }

    /**
     * This method triggers the creation of new instructor.
     *
     * @param university University object for look up information
     */
    private static void triggerCreateNewInstructor(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("**** \uD83D\uDE00 **** Section for create new instructor **** \uD83D\uDE00 ****\n");

        String fullName = "", username = "";
        double baseSalary = 0;
        int instructorType = 0,  experienceOrActiveHrs = 0;

        try {
            System.out.println("Type full name");
            fullName = scan.nextLine();

            System.out.println("Type username");
            username = scan.nextLine();

            System.out.println("Type base salary");
            baseSalary = scan.nextDouble();

            System.out.println("Type: 1. for Full Time Instructor | 2. for Full Time Instructor");
            instructorType = scan.nextInt();

            if (instructorType == 1) {
                System.out.println("Type experience years");
                experienceOrActiveHrs = scan.nextInt();
            } else if (instructorType == 2) {
                System.out.println("Type active hours per month");
                experienceOrActiveHrs = scan.nextInt();
            } else {
                System.out.println("\nOption not valid");
            }

        } catch (Exception ex) {
            System.out.println(errorMessage());
        }

        if (!fullName.equalsIgnoreCase("") && !username.equalsIgnoreCase("")
                && baseSalary != 0 && instructorType != 0 && experienceOrActiveHrs != 0) {

            System.out.println("\n" + university.createNewInstructor(fullName, username, baseSalary,
                    experienceOrActiveHrs, instructorType));
        }else{
            System.out.println("\n" + invalidInputs());
        }

        System.out.println("\n" + comingBackMessage());
    }


    /**
     * This method triggers the creation of new student.
     *
     * @param university University object for look up information
     */
    private static void triggerCreateNewStudent(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("**** \uD83D\uDE00 **** Section for create new student **** \uD83D\uDE00 ****\n");

        String fullName = "", username = "";
        int studentAge = 0;

        try {
            System.out.println("Type full name");
            fullName = scan.nextLine();

            System.out.println("Type username");
            username = scan.nextLine();

            System.out.println("Type student age");
            studentAge = scan.nextInt();
        } catch (Exception ex) {
            System.out.println(errorMessage());
        }

        if (!fullName.equalsIgnoreCase("") && !username.equalsIgnoreCase("")
                && studentAge != 0) {
            System.out.println("\n" + university.createNewStudent(fullName, username, studentAge));
        }else{
            System.out.println("\n" + invalidInputs());
        }

        System.out.println("\n" + comingBackMessage());
    }

    /**
     * This method triggers the creation of new subject.
     *
     * @param university University object for look up information
     */
    private static void triggerCreateNewSubject(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("**** \uD83D\uDCDA **** Section for create new subject **** \uD83D\uDCDA ****\n");

        String subjectName = "";
        int instructorId = 0;

        try {
            System.out.println("Type subject name");
            subjectName = scan.nextLine();

            System.out.println("Type instructor id for the subject");
            instructorId = scan.nextInt();
        } catch (Exception ex) {
            System.out.println(errorMessage());
        }

        if (!subjectName.equalsIgnoreCase("") && instructorId != 0) {
            System.out.println("\n" + university.createNewSubject(subjectName, instructorId));
        }else{
            System.out.println("\n" + invalidInputs());
        }

        System.out.println("\n" + comingBackMessage());
    }

    /**
     * This method triggers the addition of student in subject student list.
     *
     * @param university University object for look up information
     */
    private static void triggerAddSubjectStudentByIndex(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("**** ✏ **** Section for add student to a subject **** ✏ ****\n");

        int subjectId = 0;
        int studentId = 0;

        try {
            System.out.println("Type subject id");
            subjectId = scan.nextInt();

            System.out.println("Type student id");
            studentId = scan.nextInt();
        } catch (Exception ex) {
            System.out.println(errorMessage());
        }

        if (subjectId != 0 && studentId != 0) {
            System.out.println("\n" + university.addSubjectStudentById(subjectId, studentId));
        }else{
            System.out.println("\n" + invalidInputs());
        }

        System.out.println("\n" + comingBackMessage());
    }

}