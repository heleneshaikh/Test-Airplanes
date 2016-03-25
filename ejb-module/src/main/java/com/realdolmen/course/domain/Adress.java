package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by heleneshaikh on 24/03/16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Adress.findAll", query = "SELECT a FROM Adress a")
})

public class Adress implements Serializable {
    public static final String FIND_ALL = "Adress.findAll";
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private BigDecimal id;
    private String city;
    private String state;
    @Column(length=400)
    private String street1;
    @Column(length=400)
    private String street2;
    @Version
    private int version;
    private int zipCode;

    public Adress() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
