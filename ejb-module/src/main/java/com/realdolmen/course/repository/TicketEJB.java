package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by heleneshaikh on 21/03/16.
 */

@Stateless
@LocalBean
public class TicketEJB implements TicketEJBRemote {

    @PersistenceContext
    EntityManager em;

    public TicketEJB() {
    }

    @Override
    public void createTicket(Ticket ticket) {
        em.persist(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        em.merge(ticket);

    }

    @Override
    public void deleteTicket(Ticket ticket) {
        em.remove(ticket);
    }

    /*
    public double getPrice(long id) {
        Query query = em.createQuery("SELECT t.price FROM Ticket t WHERE t.id = :myTicketId");
        query.setParameter("myTicketId", id);
        return (double) query.getSingleResult();
    }
    */


}
