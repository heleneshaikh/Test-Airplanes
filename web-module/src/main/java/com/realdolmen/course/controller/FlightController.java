package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.repository.FlightEJB;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by heleneshaikh on 23/03/16.
 */

@Named
@RequestScoped
public class FlightController {

    @Inject
    FlightEJB flightEJB;

    public List<Flight> getFlightNumbers() {
        return flightEJB.getAllNumbers();
    }

}
