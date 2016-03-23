package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Passenger;
import org.jboss.resteasy.core.ExceptionAdapter;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

/**
 * Created by heleneshaikh on 21/03/16.
 */
public class PassengerTest {

    private static EntityManagerFactory emf;
    private static PassengerEJB passengerEJB;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("Test");
        passengerEJB = new PassengerEJB();
    }


    @Test
    public void addPassenger() throws Exception {
        Passenger passenger = new Passenger();
        assertNull("passenger id must be null", passenger.getId());
    }

    @Test
    public void findPassengerByIdTest() throws Exception {
        Passenger passenger = passengerEJB.findPassengerById(60L);
        assertNotNull("cannot find passenger", passenger);
        assertEquals(new Long(60L), passenger.getId());

    }

}


