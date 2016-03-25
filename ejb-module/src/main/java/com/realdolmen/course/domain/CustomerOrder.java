package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by heleneshaikh on 24/03/16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c"),
})

public class CustomerOrder implements Serializable {
    public static final String FIND_ALL = "CustomerOrder.findAll";
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private BigDecimal id;
    @Version
    private int version;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private String status;
    @ManyToOne
    private Customer customer;

    public CustomerOrder() {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
