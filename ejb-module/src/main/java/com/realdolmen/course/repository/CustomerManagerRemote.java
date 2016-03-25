package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.domain.CustomerOrder;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by heleneshaikh on 25/03/16.
 */


public interface CustomerManagerRemote {
    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    void removeCustomer(Customer customer);

    List<Customer> getCustomerFindAll();

    void removeAdress(Adress adress);

    List <Adress> getAdressFindAll();

    void removeCustomerOrder(CustomerOrder customerOrder);

    List <CustomerOrder> getCustomerOrderFindAll();
}
