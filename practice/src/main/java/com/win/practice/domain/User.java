package com.win.practice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// lets Spring know that User classes are an entity stored in the database
// also indicates User is a jpa @Entity.
// assumes @Entity will be mapped to table called User
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserID;
    private String firstName,lastName;

    private User(){
        //@Entity requires a no-argument constructor
        //Spring does NOT default
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("ID: %d Name: %s %s", UserID, firstName, lastName);
    }

    public long getUserID() { return UserID; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
