package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.domain.CustomerOrder;

import javax.annotation.ManagedBean;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by heleneshaikh on 24/03/16.
 */

@Stateless
//Why no interface and @Local?
public class CustomerManager {

    @PersistenceContext
    private EntityManager em;

    public CustomerManager() {

    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public void removeCustomer(Customer customer) {
        customer = em.find(Customer.class, customer.getId());
        em.remove(customer);
    }

    public List<Customer> getCustomerFindAll() {
        return em.createNamedQuery(Customer.FIND_ALL, Customer.class).getResultList();
    }

    public void removeAdress(Adress adress) {
        adress = em.find(Adress.class, adress.getId());
        em.remove(adress);
    }

    public List <Adress> getAdressFindAll() {
        return em.createNamedQuery(Adress.FIND_ALL, Adress.class).getResultList();
    }

    public void removeCustomerOrder(CustomerOrder customerOrder) {
        customerOrder = em.find(CustomerOrder.class, customerOrder.getId());
        em.remove(customerOrder);
    }

    public List <CustomerOrder> getCustomerOrderFindAll() {
        return em.createNamedQuery(CustomerOrder.FIND_ALL, CustomerOrder.class).getResultList();
    }

}
