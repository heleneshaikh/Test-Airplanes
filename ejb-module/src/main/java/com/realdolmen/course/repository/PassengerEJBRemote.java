package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by heleneshaikh on 21/03/16.
 */

@Local
public interface PassengerEJBRemote {

    void create(Passenger passenger);

    void update(Passenger passenger);

    void delete(Passenger passenger);

    Passenger findPassengerById(Long id);

    List<Passenger> findAllPassengers();

}
