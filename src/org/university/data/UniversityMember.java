package org.university.data;

/**
 * This class initialize the attributes needed for
 * create a new university member. This means, this class
 * includes all students and instructors of the institution.
 */
public class UniversityMember {
    // attributes
    protected String fullName;
    protected String username;

    // constructor
    public UniversityMember() {
    }

    public UniversityMember(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }

    // methods
    public String getUsername() {
        return username;
    }
}
