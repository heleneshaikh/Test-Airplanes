package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by heleneshaikh on 21/03/16.
 */

@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Temporal(TemporalType.DATE)
    private Date departureTime;
    @Temporal(TemporalType.DATE)
    private Date arrivalTime;
    @ManyToMany
    private List<Passenger> passengerList;

    @OneToMany(mappedBy = "outbound")
    private List<Ticket> outboundList;
    @OneToMany(mappedBy = "inbound")
    private List<Ticket> inboundList;


    public Flight() {
    }

    public Flight(String number, Date departureTime, Date arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<Ticket> getOutboundList() {
        return outboundList;
    }

    public void setOutboundList(List<Ticket> outboundList) {
        this.outboundList = outboundList;
    }

    public List<Ticket> getInboundList() {
        return inboundList;
    }

    public void setInboundList(List<Ticket> inboundList) {
        this.inboundList = inboundList;
    }
}
