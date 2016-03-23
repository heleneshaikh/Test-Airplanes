package com.realdolmen.course.repository;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by heleneshaikh on 23/03/16.
 */

@ManagedBean
@Named
public class RegistrationEJB {

    private String firstName;
    private String lastName;
    private Gender gender;

    public enum Gender {
        FEMALE, MALE;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @PostConstruct
    public void init() {
        this.firstName = "Pixie";
        this.lastName = "Whitley";
    }
}
