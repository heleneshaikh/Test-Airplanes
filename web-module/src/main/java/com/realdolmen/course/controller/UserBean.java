package com.realdolmen.course.controller;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by heleneshaikh on 25/03/16.
 */

@Named("user") //you can now use user.name, user.password, etc
@SessionScoped //Different users are given different instances of the bean object
               // when you do user.bean => jsf creates an object of the class UserBean.
               // the object then stays alive for the duration of the session
public class UserBean implements Serializable {
    private String name;
    private String password;

    public UserBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Pixie";

    }
}
