package org.university.data;

public class UniversityMember {
    // attributes
    private String fullName;
    private String username;

    // constructor
    public UniversityMember() {}

    public UniversityMember(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }

    // methods
    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return fullName + ", username = " + username;
    }
}
