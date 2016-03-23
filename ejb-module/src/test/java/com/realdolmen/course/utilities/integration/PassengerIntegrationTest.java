package com.realdolmen.course.utilities.integration;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.repository.PassengerEJBRemote;
import org.junit.Test;

import java.util.List;

/**
 * Created by heleneshaikh on 21/03/16.
 */
public class PassengerIntegrationTest extends JNDITest {

    private static String jndi = "jee7-starter/ejb-module/PassengerEJB!com.realdolmen.course.repository.PassengerEJBRemote";

    @Test
    public void findAllPassengers() throws Exception {
        PassengerEJBRemote repository = lookup(jndi);
        List<Passenger> passengers = repository.findAllPassengers();
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getFirstName());
        }

    }
}
