package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Ticket;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * Created by heleneshaikh on 21/03/16.
 */


@Remote
public interface TicketEJBRemote {

    void createTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    void deleteTicket(Ticket ticket);
}
