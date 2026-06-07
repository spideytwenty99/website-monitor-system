package com.websitemonitor.model;

import java.util.Date;

// Handles account creation and authentication.
public class Registration {
    private int ID;
    private Date registrationDate;

    public Registration(int id){
        this.ID               = id;
        this.registrationDate = new Date();
    }

    public void createAccount(User u){
        System.out.println("Account created: "+u.getUsername());
    }

    public boolean authenticateUser(User u, String password){
            return u.login(password);
    }
}
