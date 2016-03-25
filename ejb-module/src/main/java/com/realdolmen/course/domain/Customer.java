package com.realdolmen.course.domain;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by heleneshaikh on 24/03/16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
        @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
})


public class Customer implements Serializable {
    public static final String FIND_ALL = "Customer.findAll";
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private BigDecimal id;
    @Version
    private int version;
    @Column(length = 4000)
    private String email;
    @OneToMany(mappedBy = "customer")
    List<CustomerOrder> customerOrders;
    @OneToOne
    private Adress billingAdress;
    @OneToOne
    private Adress shippingAdress;


    public Customer() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        if (customerOrders == null) {
            customerOrders = new ArrayList<CustomerOrder>();
        }
        customerOrders.add(customerOrder);
        customerOrder.setCustomer(this);
        return customerOrder;
    }

    public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
        getCustomerOrders().remove(customerOrder);
        customerOrder.setCustomer(null);
        return customerOrder;
    }

    public Adress getBillingAdress() {
        return billingAdress;
    }

    public void setBillingAdress(Adress billingAdress) {
        this.billingAdress = billingAdress;
    }

    public Adress getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(Adress shippingAdress) {
        this.shippingAdress = shippingAdress;
    }



}
