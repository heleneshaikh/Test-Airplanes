package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by heleneshaikh on 21/03/16.
 */


@Stateless
@LocalBean
public class PassengerEJB implements PassengerEJBRemote {

    @PersistenceContext
    EntityManager em;

    public PassengerEJB() {
    }

    @ManagedProperty("21")
    private String age;

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return this.age;
    }


    @Override
    public void create(Passenger passenger) {
        em.persist(passenger);
    }

    @Override
    public void update(Passenger passenger) {
        em.merge(passenger);

    }

    @Override
    public void delete(Passenger passenger) {
        em.remove(passenger);
    }

    @Override
    public Passenger findPassengerById(Long id) {
        return em.find(Passenger.class, id);
    }

    @Override
    public List<Passenger> findAllPassengers() {
        List <Passenger> results = em.createNamedQuery(Passenger.FIND_ALL).getResultList();
        return results;
    }

    public String getFirstName(String lastName) {
        Query query = em.createQuery("SELECT p.firstName FROM Passenger p WHERE p.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return (String) query.getSingleResult();
    }

    public String findByFirstName(String firstName) {
       Query query = em.createNamedQuery(Passenger.FIND_BY_LAST_NAME).setParameter("firstName", firstName);
        return (String) query.getSingleResult();
    }


}
