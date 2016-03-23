package com.realdolmen.course.domain;

import javax.persistence.Embeddable;

/**
 * Created by heleneshaikh on 21/03/16.
 */

@Embeddable
public class Address {
    private String zipcode;
    private String country;

    public Address() {
    }

    public Address(String zipcode, String country) {
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
