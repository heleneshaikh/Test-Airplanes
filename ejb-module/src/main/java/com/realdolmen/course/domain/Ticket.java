package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by heleneshaikh on 21/03/16.
 */

@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private Flight inbound;
    @ManyToOne
    private Flight outbound;


    public Ticket() {
    }

    public Ticket(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getInbound() {
        return inbound;
    }

    public void setInbound(Flight inbound) {
        this.inbound = inbound;
    }

    public Flight getOutbound() {
        return outbound;
    }

    public void setOutbound(Flight outbound) {
        this.outbound = outbound;
    }
}
