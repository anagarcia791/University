package org.university.data;

public class UniversityMember {
    // attributes
    private final String fullName;
    private final String username;

    // constructor
    public UniversityMember(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }

    // methods
    @Override
    public String toString() {
        return fullName + ", username = " + username;
    }
}
