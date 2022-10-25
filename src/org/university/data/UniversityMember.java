package org.university.data;

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
