package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.repository.PassengerEJB;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by heleneshaikh on 23/03/16.
 */

@Named
@RequestScoped
public class PassengerController {

    @Inject
    PassengerEJB passengerEJB;
    private Passenger passenger;


    public void save(Passenger passenger) {
        passengerEJB.create(passenger);
    }
    public List<Passenger> getAllPassengers() {
        return passengerEJB.findAllPassengers();
    }

    public Passenger findById(Long id) {
        return passengerEJB.findPassengerById(id);
    }

}
