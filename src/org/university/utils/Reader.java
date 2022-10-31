package org.university.utils;

import java.util.Scanner;

public class Reader {

    private static String errorMessage() {
        return "\n       ❗       Error occurred       ❗       ";
    }

    public static int intScanner() {
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (Exception ex) {
            System.out.println(errorMessage());
            return 0;
        }
    }

    public static String stringScanner() {
        Scanner scan = new Scanner(System.in);
        return scan.next().trim();
    }
}
