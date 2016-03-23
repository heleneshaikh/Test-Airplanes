package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Flight;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by heleneshaikh on 23/03/16.
 */

@Stateless
@LocalBean
public class FlightEJB implements FlightEJBRemote {

    @PersistenceContext
    EntityManager em;

    @Override
    public void create(Flight flight) {
        em.persist(flight);
    }

    @Override
    public void update(Flight flight) {
        em.merge(flight);

    }

    @Override
    public void delete(Flight flight) {
        em.remove(flight);

    }

    @Override
    public Flight findFlightById(Long id) {
        return em.find(Flight.class, id);
    }

    @Override
    public List<Flight> findAllFlights() {
        return em.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
    }

    public List <Flight> getAllNumbers() {
        return em.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
    }

    @PostConstruct
    public void initialize() {
        Flight flight = new Flight("6", new Date(), new Date());
        create(flight);
    }


}
