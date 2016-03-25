package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by heleneshaikh on 21/03/16.
 */

@EntityListeners({ValidateNameListener.class})
@NamedQueries({
        @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
        @NamedQuery(name= "Passenger.findByFirstName", query = "SELECT p FROM Passenger p WHERE p.firstName = :firstName")
})
@Entity
public class Passenger implements Serializable{
    public static final String FIND_ALL = "Passenger.findAll";
    public static final String FIND_BY_FIRST_NAME = "Passenger.findByFirstName";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private int frequentFlyerMiles;
    @Transient
    private int age;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;
    @ManyToMany(mappedBy="passengerList")
    private List<Flight> flights;
    @Version
    private Integer version;


    public Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, int frequentFlyerMiles, int age, Address address) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.age = age;
        this.address = address;
    }

    @PreUpdate
    private void validate() {
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
