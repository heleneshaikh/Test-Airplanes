package com.realdolmen.course.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Created by heleneshaikh on 21/03/16.
 */
public class ValidateNameListener {

    @PrePersist
    @PreUpdate

    private void validateName(Passenger passenger) {
        if (passenger.getFirstName() == null) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (passenger.getLastName() == null) {
            throw new IllegalArgumentException("Invalid last name");
        }
    }
}
