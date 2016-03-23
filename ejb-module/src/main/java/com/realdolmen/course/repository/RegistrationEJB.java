package com.realdolmen.course.repository;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

/**
 * Created by heleneshaikh on 23/03/16.
 */

@ManagedBean
@Named
public class RegistrationEJB {

    private String firstName;
    private String lastName;
    private Gender gender;
    private Date datOfBirth;
    private String email;
    private String phoneNumber;
    private String accountNumber;

    public enum Gender {
        FEMALE, MALE;
    }

    public String register() {
        System.out.println("submitted");
        return "index.xhtml";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public Date getDatOfBirth() {
        return datOfBirth;
    }

    public void setDatOfBirth(Date datOfBirth) {
        this.datOfBirth = datOfBirth;
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
