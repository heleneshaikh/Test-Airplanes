package com.realdolmen.course.domain;

import javax.persistence.Embeddable;

/**
 * Created by heleneshaikh on 21/03/16.
 */

@Embeddable
public class PassengerId {
    private String ssn;
    private String firstName;

    public PassengerId() {
    }

    public PassengerId(String ssn, String firstName) {
        this.ssn = ssn;
        this.firstName = firstName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
