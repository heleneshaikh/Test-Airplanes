package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Flight;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by heleneshaikh on 23/03/16.
 */

@Local
public interface FlightEJBRemote {

    void create(Flight flight);
    void update(Flight flight);
    void delete(Flight flight);
    Flight findFlightById(Long id);
    List<Flight> findAllFlights();

}
